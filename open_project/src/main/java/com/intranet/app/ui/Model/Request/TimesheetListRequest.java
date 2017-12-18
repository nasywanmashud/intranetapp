package com.intranet.app.ui.Model.Request;

/**
 * Created by user on 12/4/2017.
 */

public class TimesheetListRequest {

    String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public TimesheetListRequest() {


    }

    public TimesheetListRequest(TimesheetSearchRequest data) {

        Username = data.getUsername();

    }


}
