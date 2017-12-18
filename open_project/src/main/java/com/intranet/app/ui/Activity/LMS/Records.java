package com.intranet.app.ui.Activity.LMS;

import java.io.Serializable;

/**
 * Created by Me-Tech on 10/19/2017.
 */

public class Records implements Serializable {
    String SVName;
    String RefNo;
    String Staff;
    String AppliedDate;
    String LeaveType;
    String DateFrom;
    String DateTo;
    String Days;
    String ApproverRemarks;
    String UserRemarks;
    String ApprovalStatus;

    public Records (String a , String b , String c , String d ,String e, String f, String g, String h ,String i, String j , String k){

         SVName = a;
         RefNo=b;
         Staff=c;
         AppliedDate=d;
         LeaveType=e;
         DateFrom =f;
        DateTo=g;
         Days=h;
         ApproverRemarks=i;
         UserRemarks=j;
         ApprovalStatus=k;

    }

    public  Records() {}

    public String getSVName() {
        return SVName;
    }

    public String getRefNo() {
        return RefNo;
    }

    public String getStaff() {
        return Staff;
    }

    public String getAppliedDate() {
        return AppliedDate;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public String getDateTo() {
        return DateTo;
    }

    public String getDays() {
        return Days;
    }

    public String getApproverRemarks() {
        return ApproverRemarks;
    }

    public String getUserRemarks() {
        return UserRemarks;
    }

    public String getApprovalStatus() {
        return ApprovalStatus;
    }


}
