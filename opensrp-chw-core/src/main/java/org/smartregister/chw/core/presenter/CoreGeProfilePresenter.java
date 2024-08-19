package org.smartregister.chw.core.presenter;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.smartregister.chw.core.contract.CoreGeProfileContract;
import org.smartregister.commonregistry.CommonPersonObjectClient;


public class CoreGeProfilePresenter implements CoreGeProfileContract.Presenter {

    private String data;

    @Override
    public void processDataToEvent(String data) {
        this.data=data;
    }

    @Override
    public JSONObject getJsonForm(CommonPersonObjectClient commonPersonObjectClient, String formName) {
        return new JSONObject();
    }

    @Override
    public CoreGeProfileContract.ClientInfo getClientsInfo(CommonPersonObjectClient clientsInfo) {
        return null;
    }


}
