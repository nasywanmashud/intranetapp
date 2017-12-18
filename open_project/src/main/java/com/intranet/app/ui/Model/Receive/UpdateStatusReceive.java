package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class UpdateStatusReceive {

    String Status ;
    String Data;

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public UpdateStatusReceive(UpdateStatusReceive returnData) {

        Status = returnData.getStatus();
        Data = returnData.getData();

    }
}
