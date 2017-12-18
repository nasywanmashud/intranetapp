package com.intranet.app.ui.Activity.HomePage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.intranet.app.R;
import com.intranet.app.ui.Model.Receive.AttendanceHistoryReceive;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class AttandanceHistoryAdapter extends BaseAdapter {

    private Activity mContext;

    AttendanceHistoryReceive Details;

    public AttandanceHistoryAdapter(Activity mContext, AttendanceHistoryReceive DetailList) {
        this.mContext = mContext;
        this.Details = DetailList;
    }

    @Override
    public int getCount() {
        return Details.getHistory().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getHistory().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{

        @Bind(R.id.Date)
        TextView txtDate;

        @Bind(R.id.clockIn)
        TextView txtClock_in1;

        @Bind(R.id.clockOut)
        TextView txtClock_out1;

        @Bind(R.id.clockIn2)
        TextView txtClock_in2;

        @Bind(R.id.clockOut2)
        TextView txtClock_out2;

        @Bind(R.id.totalHours)
        TextView txtTotal_hours;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_pop_staff_attandance, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        //Set text for TextView

//        if (Details.getHistory().get(position).getClockIn2().equals(null)){
//            vh.txtClock_in2.setText("            ");
//
//        }

        vh.txtDate.setText(Details.getHistory().get(position).getDate());
        vh.txtClock_in1.setText(Details.getHistory().get(position).getClockIn1());
        vh.txtClock_out1.setText(Details.getHistory().get(position).getClockOut1());
        vh.txtClock_in2.setText(Details.getHistory().get(position).getClockIn2());
        vh.txtClock_out2.setText(Details.getHistory().get(position).getClockOut2());
        vh.txtTotal_hours.setText(Details.getHistory().get(position).getTotalHours());

        return view;

        //save product id to tag
    }

}


