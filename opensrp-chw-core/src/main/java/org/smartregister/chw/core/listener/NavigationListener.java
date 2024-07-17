package org.smartregister.chw.core.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import org.smartregister.chw.core.R;
import org.smartregister.chw.core.adapter.NavigationAdapter;
import org.smartregister.chw.core.utils.CoreConstants;
import org.smartregister.util.Utils;

public class NavigationListener implements View.OnClickListener {

    private Activity activity;
    private NavigationAdapter navigationAdapter;

    public NavigationListener(Activity activity, NavigationAdapter adapter) {
        this.activity = activity;
        this.navigationAdapter = adapter;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() instanceof String) {
            String tag = (String) v.getTag();
            switch (tag) {
                case CoreConstants.DrawerMenu.CHILD_CLIENTS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.CHILD_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.ALL_FAMILIES:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.FAMILY_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.ANC:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.ANC_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.LD:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.LD));
                    break;
                case CoreConstants.DrawerMenu.PNC:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.PNC_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.FAMILY_PLANNING:
                    Class fPlanning = getActivity(CoreConstants.REGISTERED_ACTIVITIES.FP_REGISTER_ACTIVITY);
                    if (fPlanning == null) {
                        Toast.makeText(activity.getApplicationContext(), CoreConstants.DrawerMenu.FAMILY_PLANNING, Toast.LENGTH_SHORT).show();
                    } else {
                        startRegisterActivity(fPlanning);
                    }
                    break;

                case CoreConstants.DrawerMenu.MALARIA:
                    Class malaria = getActivity(CoreConstants.REGISTERED_ACTIVITIES.MALARIA_REGISTER_ACTIVITY);
                    if (malaria == null) {
                        Toast.makeText(activity.getApplicationContext(), CoreConstants.DrawerMenu.MALARIA, Toast.LENGTH_SHORT).show();
                    } else {
                        startRegisterActivity(malaria);
                    }
                    break;
                case CoreConstants.DrawerMenu.ICCM:
                    Class iccm = getActivity(CoreConstants.REGISTERED_ACTIVITIES.ICCM_REGISTER_ACTIVITY);
                    if (iccm == null) {
                        Toast.makeText(activity.getApplicationContext(), CoreConstants.DrawerMenu.ICCM, Toast.LENGTH_SHORT).show();
                    } else {
                        startRegisterActivity(iccm);
                    }
                    break;
                case CoreConstants.DrawerMenu.REFERRALS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.REFERRALS_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.LTFU:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.LTFU_REFERRALS_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.CDP:
                case CoreConstants.DrawerMenu.CDP_HF:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.CDP_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.LAB:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.LAB_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.HIV_SELF_TESTING:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.HIV_SELF_TESTING_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.KVP_PrEP:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.KVP_PrEP_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.KVP:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.KVP_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.PrEP:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.PrEP_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.AGYW:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.AGYW_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.ALL_CLIENTS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.ALL_CLIENTS_REGISTERED_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.UPDATES:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.UPDATES_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.HIV_CLIENTS:
                case CoreConstants.DrawerMenu.CBHS_CLIENTS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.HIV_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.HTS_CLIENTS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.HTS_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.HIV_INDEX_CLIENTS:
                case CoreConstants.DrawerMenu.HIV_INDEX_CLIENTS_HF:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.HIV_INDEX_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.TB_CLIENTS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.TB_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.PMTCT:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.PMTCT_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.MOTHER_CHAMPION:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.MOTHER_CHAMPION_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.HEI:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.HEI));
                    break;
                case CoreConstants.DrawerMenu.REPORTS:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.REPORTS));
                    break;
                case CoreConstants.DrawerMenu.VMMC:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.VMMC_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.SBC:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.SBC_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.GBV:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.GBV_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.SBC_MONTHLY_SOCIAL_MEDIA_REPORT:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.SBC_MONTHLY_SOCIAL_MEDIA_REGISTER_ACTIVITY));
                    break;
                case CoreConstants.DrawerMenu.ADDO_LINKAGE:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.ADDO_LINKAGE_ACTIVITY));
                    break;

//                    Map Navigation Menu with Register Activity
                case CoreConstants.DrawerMenu.GE:
                    startRegisterActivity(getActivity(CoreConstants.REGISTERED_ACTIVITIES.GE_REGISTER_ACTIVITY));
                    break;
                default:
                    Utils.showShortToast(activity.getApplicationContext(), "Unspecified navigation action");
                    break;
            }
            navigationAdapter.setSelectedView(tag);
        }
    }

    public void startRegisterActivity(Class registerClass) {
        if (registerClass != null) {
            Intent intent = new Intent(activity, registerClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            activity.finish();
        }
    }

    private Class getActivity(String key) {
        return navigationAdapter.getRegisteredActivities().get(key);
    }
}
