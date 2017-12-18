package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class TimesheetApprovalRequest {

    /*Local Data  Send To Server*/
    String Username;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }



    /*Initiate Class*/
    public TimesheetApprovalRequest() {


    }

    public TimesheetApprovalRequest(TimesheetApprovalRequest data) {

        Username = data.getUsername();

    }
}