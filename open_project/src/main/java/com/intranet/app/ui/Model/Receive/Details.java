package com.intranet.app.ui.Model.Receive;

/**
 * Created by Me-Tech on 9/25/2017.
 */

public class Details {


    String Title;
    String Abstract;
    String ContentRefId;

    public String getContentRefId() {
        return ContentRefId;
    }

    public void setContentRefId(String contentRefId) {
        ContentRefId = contentRefId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }
}
