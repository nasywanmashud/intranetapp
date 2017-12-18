package com.intranet.app.ui.Activity.LMS.MyLeave;

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

import com.intranet.app.R;
import com.intranet.app.ui.Activity.LMS.LeaveAppListActivity;
import com.intranet.app.ui.Activity.LMS.LeaveAppListFragment;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalActivity;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
import com.intranet.app.ui.Model.Receive.LmsListReceive;
import com.intranet.app.ui.Model.Receive.RecordList;
import com.intranet.app.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class LmslistAdapter extends BaseAdapter {

    private Activity mContext;
    ArrayList<String>appStatus = new ArrayList<String>();
    LeaveApprovalFragment fragment;
    String approverremark , RefNo ,updatestatus;
    ArrayList<RecordList> leaveapps = new ArrayList<>();
    String appmark;

    LmsListReceive Details;

    public LmslistAdapter(Activity mContext, LmsListReceive DetailList, ArrayList<String> appStatus, LeaveApprovalFragment fragment) {
        this.mContext = mContext;
        this.Details = DetailList;
        this.appStatus = appStatus;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return Details.getRecordList().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getRecordList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{

        @Bind(R.id.supervisorname)
        TextView txtsvname;

        @Bind(R.id.refid)
        TextView txtrefid;

        @Bind(R.id.applieddate)
        TextView txtapplieddate;

        @Bind(R.id.staff)
        TextView txtstaff;

        @Bind(R.id.leavetype1)
        TextView txtleavetype;

        @Bind(R.id.stafremarks)
        TextView txtstafremarks;

        @Bind(R.id.datefrom)
        TextView txtdatefrom;

        @Bind(R.id.dateto)
        TextView txtdateto;

        @Bind(R.id.days)
        TextView txtdays;

        @Bind(R.id.reliefstaff)
        TextView txtreliefstaff;

        @Bind(R.id.appstatus)
        Spinner spinappstatus;

        @Bind(R.id.tag)
        ImageView img;

        @Bind(R.id.update)
        Button btnupdate;

        @Bind(R.id.approverremark)
        EditText txtapproverremark;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

       // final String approverremark , RefNo ,updatestatus;
//        final String[] selectedAppType = new String[1];

        final ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_leaveapplist, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        final SharedPrefManager pref;

        pref = new SharedPrefManager(mContext);


        HashMap<String, String> username = pref.getUsername();
        final String  name = username.get(SharedPrefManager.USERNAME);
        //Set text for TextView
        if( Details.getRecordList().get(position).getLeaveType()  != null) {
            if (Details.getRecordList().get(position).getLeaveType().equals("Annual Leave")) {
                vh.img.setImageResource(R.drawable.tagal);
            } else if

                    (Details.getRecordList().get(position).getLeaveType().equals("Medical Leave")) {
                vh.img.setImageResource(R.drawable.tagml);
            } else if
                    (Details.getRecordList().get(position).getLeaveType().equals("Unpaid Leave")) {
                vh.img.setImageResource(R.drawable.tagul);
            } else if (Details.getRecordList().get(position).getLeaveType().equals("Emergency Leave")) {
                vh.img.setImageResource(R.drawable.tagel);

            }
        }



        vh.txtsvname.setText(Details.getRecordList().get(position).getSVName());
        vh.txtrefid.setText(Details.getRecordList().get(position).getRefNo());
        vh.txtstaff.setText(Details.getRecordList().get(position).getStaff());
        vh.txtapplieddate.setText(Details.getRecordList().get(position).getAppliedDate());
        vh.txtleavetype.setText(Details.getRecordList().get(position).getLeaveType());
        vh.txtdatefrom.setText(Details.getRecordList().get(position).getDateFrom());
        vh.txtreliefstaff.setText(Details.getRecordList().get(position).getReliefStaff());
        vh.txtdateto.setText(Details.getRecordList().get(position).getDateTo());
        vh.txtdays.setText(Details.getRecordList().get(position).getDays());
        //vh.txtapproverremarks.setText(Details.getRecords().get(position).getApproverRemarks());
        vh.txtstafremarks.setText(Details.getRecordList().get(position).getUserRemarks());
        appmark = vh.txtapproverremark.getText().toString();
       // vh.txtapproverremark.getText().toString();
        //approverremark = vh.txtapproverremarks.getText().toString();
        RefNo = vh.txtrefid.getText().toString();
        //updatestatus = vh.txtapproverremarks.toString();
        pref.setApproverRemark(approverremark);
        pref.setRefno(RefNo);




        ArrayAdapter<String> arrayAdapter12 = new ArrayAdapter<String>(mContext,
                android.R.layout.simple_dropdown_item_1line, appStatus);
        vh.spinappstatus.setAdapter(arrayAdapter12);

        vh.spinappstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                //selectedAppType[arg2] =vh.spinappstatus.getSelectedItem().toString();

                updatestatus = vh.spinappstatus.getSelectedItem().toString();
                pref.setUpdateStatus(vh.spinappstatus.getSelectedItem().toString());
                Log.e("appstatus", String.valueOf(pref.getUpdateStatus()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //pref.setUpdateStatus(vh.spinappstatus.getSelectedItem().toString());
            }
        });

        vh.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    fragment.updatestatus(name ,vh.txtrefid.getText().toString(),updatestatus , appmark);
                    if (updatestatus.equals("Endorsed") || updatestatus.equals("Rejected")){
                        Toast.makeText(LeaveApprovalActivity.getContext(), "Update Succesfully" , Toast.LENGTH_SHORT).show();
                     }

                      //LeaveAppListActivity.getContext().finish();


            }
        });

        //fragment.Test();


        return view;

    }

}


