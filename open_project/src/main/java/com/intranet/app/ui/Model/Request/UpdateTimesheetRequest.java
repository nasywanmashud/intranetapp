package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class UpdateTimesheetRequest {



    /*Local Data Send To Server*/
    String Username;
    String EntryID;
    String Status;
    String ApproverNotes;
    String Project;

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getApproverNotes() {
        return ApproverNotes;
    }

    public void setApproverNotes(String approverNotes) {
        ApproverNotes = approverNotes;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEntryID() {
        return EntryID;
    }

    public void setEntryID(String entryID) {
        EntryID = entryID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    /*Initiate Class*/
    public UpdateTimesheetRequest() {


    }

    public UpdateTimesheetRequest(UpdateTimesheetRequest data) {
      Username = data.getUsername();
        EntryID = data.getEntryID();
        Status = data.getStatus();
        ApproverNotes = data.getApproverNotes();
        Project = data.getProject();


    }
}