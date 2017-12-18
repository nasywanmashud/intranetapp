package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class LeaveAppListRequest {


    String Username;
    String LeaveType;
    String ApplicationType;
    String DateFrom;
    String DateTo;
    //String UpdateStatusRequest ;

//    public String getUpdateStatus() {
//        return UpdateStatusRequest;
//    }
//
//    public void setUpdateStatus(String updateStatus) {
//        UpdateStatusRequest = updateStatus;
//    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public void setApplicationType(String applicationType) {
        ApplicationType = applicationType;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }

    public String getDateTo() {
        return DateTo;
    }

    public void setDateTo(String dateTo) {
        DateTo = dateTo;
    }

    public String getApprover() {
        return Approver;
    }

    public void setApprover(String approver) {
        Approver = approver;
    }

    String Approver;

    /*Initiate Class*/
    public LeaveAppListRequest() {

    }

    public LeaveAppListRequest(LeaveAppListRequest data) {

        Username = data.getUsername();
        LeaveType = data.getLeaveType();
        ApplicationType = data.getApplicationType();
        DateFrom = data.getDateFrom();
        DateTo = data.getDateTo();
        //UpdateStatusRequest = data.getUpdateStatus();
        Approver = data.getApprover();

    }
}