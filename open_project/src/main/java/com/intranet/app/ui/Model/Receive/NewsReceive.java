package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class NewsReceive {

    String Status;

    private ArrayList<Details> Details = new ArrayList<Details>();

    public ArrayList<Details> getDetails() {
        return Details;
    }

    public void setDetails(ArrayList<Details> details) {
        Details = details;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public NewsReceive(NewsReceive obj) {

        Status = obj.getStatus();
        Details = obj.getDetails();
    }
}

