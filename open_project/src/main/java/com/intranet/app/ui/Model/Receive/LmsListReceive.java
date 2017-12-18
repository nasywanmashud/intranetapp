package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class LmsListReceive {

    String Status ;
    String Status4;
    String Status1;
    String Status2;
    ArrayList<RecordList>RecordList = new ArrayList<RecordList>();
    String NoData;
    String Status3;

    public String getNoData() {
        return NoData;
    }

    public void setNoData(String noData) {
        NoData = noData;
    }

    public String getStatus4() {
        return Status4;
    }

    public void setStatus4(String status4) {
        Status4 = status4;
    }

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String status1) {
        Status1 = status1;
    }

    public String getStatus2() {
        return Status2;
    }

    public void setStatus2(String status2) {
        Status2 = status2;
    }

    public String getStatus3() {
        return Status3;
    }

    public void setStatus3(String status3) {
        Status3 = status3;
    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<com.intranet.app.ui.Model.Receive.RecordList> getRecordList() {
        return RecordList;
    }

    public void setRecordList(ArrayList<com.intranet.app.ui.Model.Receive.RecordList> recordList) {
        RecordList = recordList;
    }

    public LmsListReceive(LmsListReceive returnData) {


        Status = returnData.getStatus();
        RecordList = returnData.getRecordList();
        //AppStatus = returnData.getAppStatus();
        Status1 = returnData.getStatus1();
        Status2= returnData.getStatus2();
        Status3 = returnData.getStatus3();
        Status4 = returnData.getStatus4();



    }
}
