package com.intranet.app.ui.Model.Receive;

public class LoginReceive {

    String Status;
    String  Username;
    String  Email;
    String ProfilePicture;
    String userid;
    String ICNumber;
    String PhoneNumber;
    String StaffLevel;
    String Name;

    public String getStaffLevel() {
        return StaffLevel;
    }

    public void setStaffLevel(String staffLevel) {
        StaffLevel = staffLevel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getICNumber() {
        return ICNumber;
    }

    public void setICNumber(String ICNumber) {
        this.ICNumber = ICNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }




    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }



    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    // String userid;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }



    public LoginReceive(LoginReceive returnData) {

        Username = returnData.getUsername();
        Status = returnData.getStatus();
        userid = returnData.getUserid();
        ProfilePicture = returnData.getProfilePicture();
        Email = returnData.getEmail();
        PhoneNumber = returnData.getPhoneNumber();
        ICNumber = returnData.getICNumber();
        Name= returnData.getName();
        StaffLevel= returnData.getStaffLevel();


    }



}
