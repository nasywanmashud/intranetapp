package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class MyLeaveReceive {

    String Status;
    private ArrayList<LeaveType> LeaveType = new ArrayList<LeaveType>();
    private ArrayList<AnnualLeave> AnnualLeave = new ArrayList<AnnualLeave>();
    private ArrayList<MedicalLeave> MedicalLeave = new ArrayList<MedicalLeave>();
    private ArrayList<UnpaidLeave> UnpaidLeave = new ArrayList<UnpaidLeave>();

    public ArrayList<AnnualLeave> getAnnualLeave() {
        return AnnualLeave;
    }

    public void setAnnualLeave(ArrayList<AnnualLeave> annualLeave) {
        AnnualLeave = annualLeave;
    }

    public ArrayList<MedicalLeave> getMedicalLeave() {
        return MedicalLeave;
    }

    public void setMedicalLeave(ArrayList<MedicalLeave> medicalLeave) {
        MedicalLeave = medicalLeave;
    }

    public ArrayList<UnpaidLeave> getUnpaidLeave() {
        return UnpaidLeave;
    }

    public void setUnpaidLeave(ArrayList<UnpaidLeave> unpaidLeave) {
        UnpaidLeave = unpaidLeave;
    }

    public ArrayList<LeaveType> getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(ArrayList<LeaveType> leaveType) {
        LeaveType = leaveType;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public MyLeaveReceive(MyLeaveReceive obj) {

        Status = obj.getStatus();
        LeaveType = obj.getLeaveType();
        AnnualLeave = obj.getAnnualLeave();
        MedicalLeave = obj.getMedicalLeave();
        UnpaidLeave = obj.getUnpaidLeave();

    }
}

