package com.intranet.app.ui.Model.Receive;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class UpdateTimesheetReceive {

    String Status ;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public UpdateTimesheetReceive(UpdateTimesheetReceive returnData) {

        Status = returnData.getStatus();

    }
}
