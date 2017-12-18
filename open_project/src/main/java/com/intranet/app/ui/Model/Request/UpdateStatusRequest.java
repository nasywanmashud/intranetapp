package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class UpdateStatusRequest {


  String  Username;
    String RefNo;
    String UpdateAppStatus;
    String ApproverRemarks;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String refNo) {
        RefNo = refNo;
    }

    public String getUpdateAppStatus() {
        return UpdateAppStatus;
    }

    public void setUpdateAppStatus(String updateAppStatus) {
        UpdateAppStatus = updateAppStatus;
    }

    public String getApproverRemarks() {
        return ApproverRemarks;
    }

    public void setApproverRemarks(String approverRemarks) {
        ApproverRemarks = approverRemarks;
    }

    /*Initiate Class*/
    public UpdateStatusRequest() {

    }

    public UpdateStatusRequest(UpdateStatusRequest data) {

        Username = data.getUsername();
        RefNo = data.getRefNo();
        UpdateAppStatus = data.getUpdateAppStatus();
        ApproverRemarks = data.getApproverRemarks();

    }
}