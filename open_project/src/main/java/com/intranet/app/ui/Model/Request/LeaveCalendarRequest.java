package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class LeaveCalendarRequest {


    String DateFrom;

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }

    /*Initiate Class*/
    public LeaveCalendarRequest() {

    }

    public LeaveCalendarRequest(LeaveCalendarRequest data) {

        DateFrom = data.getDateFrom();

    }
}