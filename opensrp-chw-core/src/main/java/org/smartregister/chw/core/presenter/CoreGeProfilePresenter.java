package org.smartregister.chw.core.presenter;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.smartregister.chw.core.contract.CoreGeProfileContract;
import org.smartregister.commonregistry.CommonPersonObjectClient;


public class CoreGeProfilePresenter implements CoreGeProfileContract.Presenter {

    private String data;

    @Override
    public void convertDataToEvent(String data) {
        this.data=data;
    }

    @Override
    public CoreGeProfileContract.ClientInfo getClientsInfo(CommonPersonObjectClient clientsInfo) {
        return null;
    }


}
