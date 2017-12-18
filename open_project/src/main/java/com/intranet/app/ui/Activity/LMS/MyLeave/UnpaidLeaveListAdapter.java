package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.intranet.app.R;
import com.intranet.app.ui.Model.Receive.MyLeaveReceive;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class UnpaidLeaveListAdapter extends BaseAdapter {

    private Activity mContext;

    MyLeaveReceive Details;

    public UnpaidLeaveListAdapter(Activity mContext, MyLeaveReceive DetailList) {
        this.mContext = mContext;
        this.Details = DetailList;
    }

    @Override
    public int getCount() {
        return Details.getUnpaidLeave().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getUnpaidLeave().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{

        @Bind(R.id.refno)
        TextView txtrefno;

        @Bind(R.id.applieddate)
        TextView txtapplieddate;

        @Bind(R.id.leavetype)
        TextView txtleavetype;

        @Bind(R.id.datefrom)
        TextView txtdatefrom;

        @Bind(R.id.days)
        TextView txtdays;

        @Bind(R.id.reliefstaff)
        TextView txtreliefstaff;

        @Bind(R.id.status)
        TextView txtstatus;

        @Bind(R.id.staffremarks)
        TextView txtstaffremarks;

        @Bind(R.id.dateto)
        TextView txtdateto;

        @Bind(R.id.tag)
        ImageView img;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_annualleave, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        if( Details.getUnpaidLeave().get(position).getLeaveType().equals("6")){
            vh.img.setImageResource(R.drawable.tagul);
            vh.txtleavetype.setText("Unpaid Leave");

        }
        //Set text for TextView
        vh.txtapplieddate.setText(Details.getUnpaidLeave().get(position).getAppliedDate());
        vh.txtdatefrom.setText(Details.getUnpaidLeave().get(position).getDateFrom());
        vh.txtdays.setText(Details.getUnpaidLeave().get(position).getDays());
        vh.txtreliefstaff.setText(Details.getUnpaidLeave().get(position).getReliefStaff());
        vh.txtstatus.setText(Details.getUnpaidLeave().get(position).getStatus());
        vh.txtstaffremarks.setText(Details.getUnpaidLeave().get(position).getStaffRemarks());
        vh.txtrefno.setText(Details.getUnpaidLeave().get(position).getRefNo());
        vh.txtdateto.setText(Details.getUnpaidLeave().get(position).getDateTo());

        return view;

        //save product id to tag
    }

}


