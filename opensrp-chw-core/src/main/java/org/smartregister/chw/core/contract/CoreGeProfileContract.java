package org.smartregister.chw.core.contract;

import org.json.JSONObject;
import org.smartregister.commonregistry.CommonPersonObjectClient;

public interface CoreGeProfileContract {

    public class ClientInfo{
        public String firstname;
        public String middlename;
        public String lastname;
        public Integer age;
        public String location;
        public String gender;
        public String uniqueId;

        public ClientInfo(String firstname, String middlename, String lastname, Integer age, String location, String gender,String uniqueId) {
            this.firstname = firstname;
            this.middlename = middlename;
            this.lastname = lastname;
            this.age = age;
            this.gender=gender;
            this.location = location;
            this.uniqueId = uniqueId;
        }

        public String getFullname(){
            return firstname+ " " +middlename+ " " +lastname;
        }

        public String getUniqueId(){
            return "ID: "+uniqueId;
        }

    }
    public interface View{
        void startFormActivity(JSONObject jsonObject);

    }
    public interface Presenter{

        void processDataToEvent(String data);

        JSONObject getJsonForm(CommonPersonObjectClient commonPersonObjectClient, String formName);

        ClientInfo getClientsInfo(CommonPersonObjectClient clientsInfo);
    }
    public interface Model{
        ClientInfo getClientsInfo(CommonPersonObjectClient clientsInfo);
    }

    public interface Interactor{
        void processDataToEvent(String data);
        JSONObject getJsonForm(CommonPersonObjectClient commonPersonObjectClient, String formName);

    }

}
