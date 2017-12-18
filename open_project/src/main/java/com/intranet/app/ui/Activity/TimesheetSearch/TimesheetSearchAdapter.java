package com.intranet.app.ui.Activity.TimesheetSearch;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.LMS.LeaveAppListActivity;
import com.intranet.app.ui.Activity.LMS.LeaveAppListFragment;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
import com.intranet.app.ui.Model.Receive.TimesheetSearchReceive;
import com.intranet.app.ui.Model.Receive.TimesheetstatusReceive;
import com.intranet.app.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class TimesheetSearchAdapter extends BaseAdapter {

    private Activity mContext;
    ArrayList<String>appStatus = new ArrayList<String>();
    ArrayList<String>Statuss = new ArrayList<String>();

    //ArrayList<String>appStatus1 = new ArrayList<String>();
    String [] appStatus1={"Submitted" , "Approved" , "Rejected"} ;

    TimesheetSearchFragment fragment;
    String approverremark , RefNo ,updatestatus ,updatestatusall;
    String appmark;
     ViewHolder vh;

    TimesheetSearchReceive Details;

    public TimesheetSearchAdapter(Activity mContext, TimesheetSearchReceive DetailList, ArrayList<String> appStatus,ArrayList<String>Statuss, TimesheetSearchFragment fragment) {
        this.mContext = mContext;
        this.Details = DetailList;
        this.appStatus = appStatus;
        this.Statuss = Statuss;
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

        @Bind(R.id.approvernotes)
        EditText txtapprovernotes;


        @Bind(R.id.status)
        Spinner spinappstatus;

        @Bind(R.id.update)
        Button btnupdate;

//        @Bind(R.id.statuss)
//        Spinner spinappstatuss;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_timesheetsearch, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        final SharedPrefManager pref;

        pref = new SharedPrefManager(mContext);

        HashMap<String, String> status1 = pref.getUpdateStatus();
        final String  status = status1.get(SharedPrefManager.UPDATESTATUS);

        HashMap<String, String> stringObject = pref.getstringObject();
        final String sobject = stringObject.get(SharedPrefManager.STRINGOBJECT);

        Gson gson = new Gson();
        TimesheetstatusReceive obj = gson.fromJson(sobject , TimesheetstatusReceive.class);

        HashMap<String, String> username = pref.getUsername();
        final String  name = username.get(SharedPrefManager.USERNAME);
        //Set text for TextView

        vh.txtproject.setText(Details.getTimesheetAppRecord().get(position).getProject());
        vh.txttask.setText(Details.getTimesheetAppRecord().get(position).getTask());
        vh.txtdate.setText(Details.getTimesheetAppRecord().get(position).getDate());
        vh.txthour.setText(Details.getTimesheetAppRecord().get(position).getHours());
        vh.txtnotes.setText(Details.getTimesheetAppRecord().get(position).getNotes());
        vh.txtcreated.setText(Details.getTimesheetAppRecord().get(position).getCreated());
        vh.txtsubmitted.setText(Details.getTimesheetAppRecord().get(position).getSubmitted());
        vh.txtapprovernotes.setText(Details.getTimesheetAppRecord().get(position).getApproverNotes());


        ArrayAdapter<String> arrayAdapter12 = new ArrayAdapter<String>(mContext,
                android.R.layout.simple_dropdown_item_1line, appStatus1);
        vh.spinappstatus.setAdapter(arrayAdapter12);


//        ArrayAdapter<CharSequence> countryCodesAdapter = ArrayAdapter.createFromResource(mContext,
//                R.array.first_spinner, android.R.layout.simple_spinner_item);
//        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        vh.spinappstatus.setAdapter(countryCodesAdapter);
//        //spin = spinstatus1.getSelectedItem().toString();
//        //pref.setUpdateStatus(spin);
//
//        vh.spinappstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                //    spinstatus2.setSelection(position);
////                    vh.spinappstatus.setSelection(position);
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });


//        ArrayAdapter<String> arrayAdapterxx = new ArrayAdapter<String>(mContext,
//                android.R.layout.simple_dropdown_item_1line, Statuss);
//        vh.spinappstatuss.setAdapter(arrayAdapterxx);

//        fragment.timesheetstatusfragment(status);
//        Statuss.clear();
//        //if (obj.getStatus().equals("True")) {
//            vh.spinappstatuss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
//                    vh.spinappstatuss.setSelection(0);
//
//                    //selectedApprover=spinapprover.getSelectedItem().toString();
//                    //pref.setApprover(selectedApprover);
//
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> arg0) {
//                    // TODO Auto-generated method stub
//
//                }
//            });
      //  }


//        ArrayAdapter<CharSequence> countryCodesAdapter = ArrayAdapter.createFromResource(mContext,
//                R.array.first_spinner, android.R.layout.simple_spinner_item);
//        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        vh.spinappstatus.setAdapter(countryCodesAdapter);
//        vh.spinappstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
//                if (status.contentEquals("Submitted")) {
//                    vh.spinappstatus.setSelection(0);

////                }else if (status.contentEquals("Approved")) {
////                    vh.spinappstatus.setSelection(1);
////
////                }else if (status.contentEquals("Rejected")) {
////                    vh.spinappstatus.setSelection(2);
////                }
//                    //selectedAppType[arg2] =vh.spinappstatus.getSelectedItem().toString();
//
//                    updatestatus = vh.spinappstatus.getSelectedItem().toString();
//                    //pref.setUpdateStatus(vh.spinappstatus.getSelectedItem().toString());
//
//                }
//
//                if (status.contentEquals("Approved")) {
//                    vh.spinappstatus.setSelection(0);
//                    ArrayAdapter<String> arrayAdapter12 = new ArrayAdapter<String>(mContext,
//                            android.R.layout.simple_dropdown_item_1line, appStatus);
//                    vh.spinappstatus.setAdapter(arrayAdapter12);
////                }else if (status.contentEquals("Approved")) {
////                    vh.spinappstatus.setSelection(1);
////
////                }else if (status.contentEquals("Rejected")) {
////                    vh.spinappstatus.setSelection(2);
////                }
//                    //selectedAppType[arg2] =vh.spinappstatus.getSelectedItem().toString();
//
//                    updatestatus = vh.spinappstatus.getSelectedItem().toString();
//                    //pref.setUpdateStatus(vh.spinappstatus.getSelectedItem().toString());
//
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//                //pref.setUpdateStatus(vh.spinappstatus.getSelectedItem().toString());
//            }
//        });



//        vh.btnupdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    fragment.updatestatus(name ,vh.txtrefid.getText().toString(),updatestatus , appmark);
//                    if (updatestatus.equals("Endorsed") || updatestatus.equals("Rejected")){
//                        Toast.makeText(LeaveAppListActivity.getContext(), "Update Succesfully" , Toast.LENGTH_SHORT).show();
//                     }
//
//                      //LeaveAppListActivity.getContext().finish();
//
//
//            }
//        });

        //fragment.Test();

        return view;

    }



}


