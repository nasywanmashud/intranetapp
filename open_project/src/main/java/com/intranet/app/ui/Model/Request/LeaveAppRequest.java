package com.intranet.app.ui.Model.Request;

import com.intranet.app.utils.App;

/**
 * Created by Dell on 11/4/2015.
 */
public class LeaveAppRequest {


    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /*Initiate Class*/
    public LeaveAppRequest() {

    }

    public LeaveAppRequest(LeaveAppRequest data) {

        username = data.getUsername();

    }
}