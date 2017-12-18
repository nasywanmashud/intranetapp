package com.intranet.app.ui.Model.Receive;

/**
 * Created by Me-Tech on 11/6/2017.
 */

public class UnpaidLeave {
    String RefNo ;
    String  AppliedDate;
    String  LeaveType;
    String  DateFrom;
    String DateTo ;
    String Days ;
    String ReliefStaff  ;
    String Status ;
    String StaffRemarks ;
    String ApproverRemarks ;

    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String refNo) {
        RefNo = refNo;
    }

    public String getAppliedDate() {
        return AppliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        AppliedDate = appliedDate;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
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

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }

    public String getReliefStaff() {
        return ReliefStaff;
    }

    public void setReliefStaff(String reliefStaff) {
        ReliefStaff = reliefStaff;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStaffRemarks() {
        return StaffRemarks;
    }

    public void setStaffRemarks(String staffRemarks) {
        StaffRemarks = staffRemarks;
    }

    public String getApproverRemarks() {
        return ApproverRemarks;
    }

    public void setApproverRemarks(String approverRemarks) {
        ApproverRemarks = approverRemarks;
    }


}
