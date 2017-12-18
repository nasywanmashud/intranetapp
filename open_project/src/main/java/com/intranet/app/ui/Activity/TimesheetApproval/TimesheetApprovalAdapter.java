package com.intranet.app.ui.Activity.TimesheetApproval;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchFragment;
import com.intranet.app.ui.Model.Receive.TimesheetListReceive;
import com.intranet.app.ui.Model.Receive.TimesheetSearchReceive;
import com.intranet.app.ui.Model.Receive.TimesheetstatusReceive;
import com.intranet.app.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 12/5/2017.
 */

public class TimesheetApprovalAdapter extends BaseAdapter {

    private Activity mContext;
    ArrayList<String> appStatus = new ArrayList<String>();
    ArrayList<String>Statuss = new ArrayList<String>();
    ArrayAdapter<CharSequence> countryCodesAdapter;
    //ArrayList<String>appStatus1 = new ArrayList<String>();
    String [] appStatus1={"Submitted" , "Approved" , "Rejected"} ;
    String spinstatus,project;
    TimesheetApprovalFragment fragment;
    //com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalAdapter.ViewHolder vh;

    TimesheetListReceive Details;

    public TimesheetApprovalAdapter(Activity mContext, TimesheetListReceive DetailList, ArrayList<String> appStatus, TimesheetApprovalFragment fragment) {
        this.mContext = mContext;
        this.Details = DetailList;
        this.appStatus = appStatus;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return Details.getTimesheetAppRecord().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getTimesheetAppRecord().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{

        @Bind(R.id.project)
        TextView txtproject;

        @Bind(R.id.task)
        TextView txttask;

        @Bind(R.id.date)
        TextView txtdate;

        @Bind(R.id.hour)
        TextView txthour;

        @Bind(R.id.notes)
        TextView txtnotes;

        @Bind(R.id.created)
        TextView txtcreated;

        @Bind(R.id.submitted)
        TextView txtsubmitted;

        @Bind(R.id.staff)
        TextView txtstaff;

        @Bind(R.id.approvernotes)
        EditText txtapprovernotes;

        @Bind(R.id.status)
        Spinner spinappstatus;

        @Bind(R.id.update)
        Button btnupdate;

        ArrayAdapter<CharSequence> countryCodesAdapter;
        ViewHolder vh;
//        @Bind(R.id.statuss)
//        Spinner spinappstatuss;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder vh;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_timesheetsearch2, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        final SharedPrefManager pref;
//
        pref = new SharedPrefManager(mContext);

        HashMap<String, String> status1 = pref.getUpdateStatus();
        final String  status = status1.get(SharedPrefManager.UPDATESTATUS);
//
        HashMap<String, String> username = pref.getUsername();
        final String  name = username.get(SharedPrefManager.USERNAME);
        //Set text for TextView

        vh.txtproject.setText(Details.getTimesheetAppRecord().get(position).getProject());
        vh.txttask.setText(Details.getTimesheetAppRecord().get(position).getTask());
        vh.txtstaff.setText(Details.getTimesheetAppRecord().get(position).getStaff());
        vh.txtdate.setText(Details.getTimesheetAppRecord().get(position).getDate());
        vh.txthour.setText(Details.getTimesheetAppRecord().get(position).getHours());
        vh.txtnotes.setText(Details.getTimesheetAppRecord().get(position).getNotes());
        vh.txtcreated.setText(Details.getTimesheetAppRecord().get(position).getCreated());
        vh.txtsubmitted.setText(Details.getTimesheetAppRecord().get(position).getSubmitted());
        vh.txtapprovernotes.setText(Details.getTimesheetAppRecord().get(position).getApproverNotes());


//        ArrayAdapter<String> arrayAdapter12 = new ArrayAdapter<String>(mContext,
//                android.R.layout.simple_dropdown_item_1line, appStatus);
//        vh.spinappstatus.setAdapter(arrayAdapter12);

       countryCodesAdapter = ArrayAdapter.createFromResource(mContext,
                R.array.first_spinner, android.R.layout.simple_spinner_item);
        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vh.spinappstatus.setAdapter(countryCodesAdapter);
        //spin = spinstatus1.getSelectedItem().toString();
        //pref.setUpdateStatus(spin);

        vh.spinappstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

              spinstatus=  vh.spinappstatus.getSelectedItem().toString();
//                pref.setUpdateStatus(spinstatus);

                //    spinstatus2.setSelection(position);
//                    vh.spinappstatus.setSelection(position);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        project = vh.txtproject.getText().toString();

        vh.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.updatestatus(name, Details.getTimesheetAppRecord().get(position).getEntryID(), spinstatus, vh.txtapprovernotes.getText().toString() ,project);
                if (status.equals("Submitted") || status.equals("Rejected") || status.equals("Approved")) {
                    Toast.makeText(mContext, "Update Succesfully", Toast.LENGTH_SHORT).show();
                }

                //LeaveAppListActivity.getContext().finish();

            }

        });

        return view;

    }

    public void test () {

        ArrayAdapter<CharSequence> countryCodesAdapter = ArrayAdapter.createFromResource(mContext,
                R.array.first_spinner, android.R.layout.simple_spinner_item);
        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }


}


