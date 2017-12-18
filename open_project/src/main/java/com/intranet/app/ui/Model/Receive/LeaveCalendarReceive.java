package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class LeaveCalendarReceive {

    String Status;

    private ArrayList<Data> Data = new ArrayList<Data>();

    public ArrayList<Data> getData() {
        return Data;
    }

    public void setData(ArrayList<Data> data) {
        Data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LeaveCalendarReceive(LeaveCalendarReceive returnData) {


        Status = returnData.getStatus();
        Data = returnData.getData();

    }
}
