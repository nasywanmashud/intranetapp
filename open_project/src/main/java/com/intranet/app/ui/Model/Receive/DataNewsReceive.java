package com.intranet.app.ui.Model.Receive;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class DataNewsReceive {

    String Title;
    String Content;
    String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public DataNewsReceive(DataNewsReceive returnData) {

       Title = returnData.getTitle();
        Content = returnData.getContent();
        Status = returnData.getStatus();
    }
}
