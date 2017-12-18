package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class AttendanceHistoryRequest {



    /*Local Data Send To Server*/
String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }






    /*Initiate Class*/
    public AttendanceHistoryRequest() {


    }

    public AttendanceHistoryRequest(AttendanceHistoryRequest data) {
      username = data.getUsername();

    }
}