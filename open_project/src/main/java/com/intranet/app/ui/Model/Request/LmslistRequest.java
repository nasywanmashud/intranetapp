package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class LmslistRequest {



    /*Local Data Send To Server*/
    String Username;






    /*Initiate Class*/

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public LmslistRequest() {


    }

    public LmslistRequest(LmslistRequest data) {

        Username = data.getUsername();

    }
}