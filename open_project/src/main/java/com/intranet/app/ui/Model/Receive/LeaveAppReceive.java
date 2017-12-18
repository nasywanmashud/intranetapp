package com.intranet.app.ui.Model.Receive;

import com.intranet.app.utils.App;

import java.util.ArrayList;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class LeaveAppReceive {

    String Status;
    private ArrayList<Approver> Approver = new ArrayList<Approver>();

    public ArrayList<Approver> getApprover() {
        return Approver;
    }

    public void setApprover(ArrayList<Approver> approver) {
        Approver = approver;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LeaveAppReceive(LeaveAppReceive returnData) {


        Status = returnData.getStatus();
        Approver = returnData.getApprover();
    }
}
