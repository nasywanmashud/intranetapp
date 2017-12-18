package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class MyLeaveRequest {


    String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    String Year;



    public MyLeaveRequest() {

    }

    public MyLeaveRequest(MyLeaveRequest data) {

        Username = data.getUsername();
        Year = data.getYear();

    }
}