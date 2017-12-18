package com.intranet.app.ui.Model.Receive;


public class TimesheetAppRecord {

        String Project;
        String Task;
        String Staff;
        String EntryID;
        String Date;
        String Hours;
        String Notes;
        String Created;
        String Submitted;
        String ApproverNotes;
        String TimesheetStatus;

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getStaff() {
        return Staff;
    }

    public void setStaff(String staff) {
        Staff = staff;
    }

    public String getEntryID() {
        return EntryID;
    }

    public void setEntryID(String entryID) {
        EntryID = entryID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String hours) {
        Hours = hours;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getSubmitted() {
        return Submitted;
    }

    public void setSubmitted(String submitted) {
        Submitted = submitted;
    }

    public String getApproverNotes() {
        return ApproverNotes;
    }

    public void setApproverNotes(String approverNotes) {
        ApproverNotes = approverNotes;
    }

    public String getTimesheetStatus() {
        return TimesheetStatus;
    }

    public void setTimesheetStatus(String timesheetStatus) {
        TimesheetStatus = timesheetStatus;
    }
}
