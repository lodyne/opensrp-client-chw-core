package org.smartregister.chw.core.presenter;

import android.app.Activity;

import org.smartregister.chw.core.contract.CoreApplication;
import org.smartregister.chw.core.contract.NavigationContract;
import org.smartregister.chw.core.interactor.NavigationInteractor;
import org.smartregister.chw.core.job.CoreBasePncCloseJob;
import org.smartregister.chw.core.job.HomeVisitServiceJob;
import org.smartregister.chw.core.job.VaccineRecurringServiceJob;
import org.smartregister.chw.core.model.NavigationModel;
import org.smartregister.chw.core.model.NavigationOption;
import org.smartregister.chw.core.utils.CoreConstants;
import org.smartregister.chw.fp.util.FamilyPlanningConstants;
import org.smartregister.chw.referral.util.Constants;
import org.smartregister.job.ImageUploadServiceJob;
import org.smartregister.job.PullUniqueIdsServiceJob;
import org.smartregister.job.SyncServiceJob;
import org.smartregister.job.SyncTaskServiceJob;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import timber.log.Timber;

public class NavigationPresenter implements NavigationContract.Presenter {

    protected NavigationContract.Model mModel;
    protected NavigationContract.Interactor mInteractor;
    protected WeakReference<NavigationContract.View> mView;
    private HashMap<String, String> tableMap = new HashMap<>();

    public NavigationPresenter(CoreApplication application, NavigationContract.View view, NavigationModel.Flavor modelFlavor) {
        mView = new WeakReference<>(view);

        mInteractor = NavigationInteractor.getInstance();
        mInteractor.setApplication(application);

        mModel = NavigationModel.getInstance();
        mModel.setNavigationFlavor(modelFlavor);

        initialize();
    }

    protected void initialize() {
        tableMap.put(CoreConstants.DrawerMenu.ALL_FAMILIES, CoreConstants.TABLE_NAME.FAMILY);
        tableMap.put(CoreConstants.DrawerMenu.CHILD_CLIENTS, CoreConstants.TABLE_NAME.CHILD);
        tableMap.put(CoreConstants.DrawerMenu.ANC_CLIENTS, CoreConstants.TABLE_NAME.ANC_MEMBER);
        tableMap.put(CoreConstants.DrawerMenu.ANC, CoreConstants.TABLE_NAME.ANC_MEMBER);
        tableMap.put(CoreConstants.DrawerMenu.PNC, CoreConstants.TABLE_NAME.ANC_PREGNANCY_OUTCOME);
        tableMap.put(CoreConstants.DrawerMenu.REFERRALS, Constants.Tables.REFERRAL);
        tableMap.put(CoreConstants.DrawerMenu.MALARIA, CoreConstants.TABLE_NAME.MALARIA_CONFIRMATION);
        tableMap.put(CoreConstants.DrawerMenu.ICCM, CoreConstants.TABLE_NAME.ICCM_ENROLLMENT);
        tableMap.put(CoreConstants.DrawerMenu.VMMC, CoreConstants.TABLE_NAME.VMMC_ENROLLMENT);
        tableMap.put(CoreConstants.DrawerMenu.FAMILY_PLANNING, FamilyPlanningConstants.TABLES.FP_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.ALL_CLIENTS, CoreConstants.TABLE_NAME.FAMILY_MEMBER);
        tableMap.put(CoreConstants.DrawerMenu.UPDATES, CoreConstants.TABLE_NAME.NOTIFICATION_UPDATE);
        tableMap.put(CoreConstants.DrawerMenu.HIV_CLIENTS, org.smartregister.chw.hiv.util.Constants.Tables.HIV);
        tableMap.put(CoreConstants.DrawerMenu.CBHS_CLIENTS, CoreConstants.TABLE_NAME.CBHS_CLIENTS);
        tableMap.put(CoreConstants.DrawerMenu.HTS_CLIENTS, CoreConstants.TABLE_NAME.HTS_MEMBERS);
        tableMap.put(CoreConstants.DrawerMenu.HIV_INDEX_CLIENTS, org.smartregister.chw.hiv.util.Constants.Tables.HIV_INDEX);
        tableMap.put(CoreConstants.DrawerMenu.HIV_INDEX_CLIENTS_HF, org.smartregister.chw.hiv.util.Constants.Tables.HIV_INDEX_HF);
        tableMap.put(CoreConstants.DrawerMenu.TB_CLIENTS, org.smartregister.chw.tb.util.Constants.Tables.TB);
        tableMap.put(CoreConstants.DrawerMenu.PMTCT, org.smartregister.chw.pmtct.util.Constants.TABLES.PMTCT_REGISTRATION);
        tableMap.put(CoreConstants.DrawerMenu.MOTHER_CHAMPION, CoreConstants.TABLE_NAME.MOTHER_CHAMPION);
        tableMap.put(CoreConstants.DrawerMenu.HEI, CoreConstants.TABLE_NAME.HEI);
        tableMap.put(CoreConstants.DrawerMenu.LD, CoreConstants.TABLE_NAME.LABOUR_AND_DELIVERY);
        tableMap.put(CoreConstants.DrawerMenu.LTFU, CoreConstants.TABLE_NAME.LTFU_REFERRALS);
        tableMap.put(CoreConstants.DrawerMenu.CDP, org.smartregister.chw.cdp.util.Constants.TABLES.CDP_OUTLET_STOCK_COUNT);
        tableMap.put(CoreConstants.DrawerMenu.CDP_HF, org.smartregister.chw.cdp.util.Constants.TABLES.CDP_ORDERS);
        tableMap.put(CoreConstants.DrawerMenu.HIV_SELF_TESTING, org.smartregister.chw.hivst.util.Constants.TABLES.HIVST_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.KVP_PrEP, org.smartregister.chw.kvp.util.Constants.TABLES.KVP_PrEP_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.KVP, org.smartregister.chw.kvp.util.Constants.TABLES.KVP_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.PrEP, org.smartregister.chw.kvp.util.Constants.TABLES.PrEP_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.AGYW, org.smartregister.chw.agyw.util.Constants.TABLES.AGYW_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.SBC, org.smartregister.chw.sbc.util.Constants.TABLES.SBC_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.SBC_MONTHLY_SOCIAL_MEDIA_REPORT, org.smartregister.chw.sbc.util.Constants.TABLES.SBC_MONTHLY_SOCIAL_MEDIA_REPORT);
        tableMap.put(CoreConstants.DrawerMenu.GBV, org.smartregister.chw.gbv.util.Constants.TABLES.GBV_REGISTER);
        tableMap.put(CoreConstants.DrawerMenu.LAB, org.smartregister.chw.lab.util.Constants.TABLES.LAB_TEST_REQUESTS);

//        Map Drawer Menu and DB table
        tableMap.put(CoreConstants.DrawerMenu.GE, CoreConstants.TABLE_NAME.GENDER_EQUALITY);
    }

    public HashMap<String, String> getTableMap() {
        return tableMap;
    }

    public void setTableMap(HashMap<String, String> tableMap) {
        this.tableMap = tableMap;
    }

    public void updateTableMap(HashMap<String, String> mp) {
        for (Map.Entry<String, String> stringEntry : mp.entrySet()) {
            tableMap.put(stringEntry.getKey(), stringEntry.getValue());
        }
    }

    @Override
    public NavigationContract.View getNavigationView() {
        return mView.get();
    }


    @Override
    public void refreshNavigationCount(final Activity activity) {

        int x = 0;
        while (x < mModel.getNavigationItems().size()) {
            final int finalX = x;
            mInteractor.getRegisterCount(tableMap.get(mModel.getNavigationItems().get(x).getMenuTitle()), new NavigationContract.InteractorCallback<Integer>() {
                @Override
                public void onResult(Integer result) {
                    mModel.getNavigationItems().get(finalX).setRegisterCount(result);
                    getNavigationView().refreshCount();
                }

                @Override
                public void onError(Exception e) {
                    // getNavigationView().displayToast(activity, "Error retrieving count for " + tableMap.get(mModel.getNavigationItems().get(finalX).getMenuTitle()));
                    Timber.e("Error retrieving count for %s", tableMap.get(mModel.getNavigationItems().get(finalX).getMenuTitle()));
                }
            });
            x++;
        }

    }


    @Override
    public void refreshLastSync() {
        // get last sync date
        getNavigationView().refreshLastSync(mInteractor.sync());
    }

    @Override
    public void displayCurrentUser() {
        getNavigationView().refreshCurrentUser(mModel.getCurrentUser());
    }

    @Override
    public void sync(Activity activity) {
        CoreBasePncCloseJob.scheduleJobImmediately(CoreBasePncCloseJob.TAG);
        HomeVisitServiceJob.scheduleJobImmediately(HomeVisitServiceJob.TAG);
        VaccineRecurringServiceJob.scheduleJobImmediately(VaccineRecurringServiceJob.TAG);
        ImageUploadServiceJob.scheduleJobImmediately(ImageUploadServiceJob.TAG);
        SyncServiceJob.scheduleJobImmediately(SyncServiceJob.TAG);
        PullUniqueIdsServiceJob.scheduleJobImmediately(PullUniqueIdsServiceJob.TAG);
        //PlanIntentServiceJob.scheduleJobImmediately(PlanIntentServiceJob.TAG);
        SyncTaskServiceJob.scheduleJobImmediately(SyncTaskServiceJob.TAG);
    }

    @Override
    public List<NavigationOption> getOptions() {
        return mModel.getNavigationItems();
    }


}
