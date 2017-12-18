package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class LoginRequest {

    /*Local Data Send To Server*/
    String username;
    String password;
    //String mobile;



    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }



    /*Initiate Class*/
    public LoginRequest() {


    }

    public LoginRequest(LoginRequest data) {

      //  mobile = data.getMobile();
        password = data.getpassword();
        username = data.getusername();

    }
}