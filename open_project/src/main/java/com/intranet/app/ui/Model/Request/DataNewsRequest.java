package com.intranet.app.ui.Model.Request;

/**
 * Created by Me-Tech on 9/26/2017.
 */

public class DataNewsRequest {

    String contentrefid;


    public String getContentrefid() {
        return contentrefid;
    }

    public void setContentrefid(String contentrefid) {
        this.contentrefid = contentrefid;
    }

    /*Initiate Class*/
    public DataNewsRequest() {

    }

    public DataNewsRequest(DataNewsRequest data) {

        //  mobile = data.getMobile();
        contentrefid = data.getContentrefid();

    }
}