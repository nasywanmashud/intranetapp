package com.intranet.app.ui.Activity.LMS;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.intranet.app.R;
import com.intranet.app.ui.Model.Receive.LeaveCalendarReceive;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class LeaveCalendarAdapter extends BaseAdapter {

    private Activity mContext;

    LeaveCalendarReceive Data;

    public LeaveCalendarAdapter(Activity mContext, LeaveCalendarReceive DetailList) {
        this.mContext = mContext;
        this.Data = DetailList;
    }

    @Override
    public int getCount() {
        return Data.getData().size();
        //return Details.get(0).getDetails().size();
    }

    @Override
    public Object getItem(int position) {
        return Data.getData().get(position);
        //return Details.get(position).getDetails().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{


        @Bind(R.id.Name)
        TextView txtname;

        @Bind(R.id.ReliefStaff)
        TextView txtreliefstaff;

        @Bind(R.id.tagleave)
        ImageView tagleave;

        @Bind(R.id.textView19)
        TextView text19;

        @Bind(R.id.txtDaytype)
        TextView txtdaytype;


        @Bind(R.id.textView21)
        TextView text21;

        @Bind(R.id.textView26)
        TextView text26;

        @Bind(R.id.textView25)
        TextView text25;

        @Bind(R.id.holiday)
        TextView txtholiday;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_leave_calendar_list, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        //Set text for TextView
//        Log.e("papapapp",Data.getData().get(position).getLeaveType());


        if(Data.getData().get(position).getType() != null ) {

            if  (Data.getData().get(position).getType().equals("Annual Leave")&&Data.getData().get(position).getStatus().equals("Pending")) {
                vh.tagleave.setImageResource(R.drawable.tagal);
                vh.txtname.setTextColor(Color.parseColor("#C1C1C1"));
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);


             } else if  (Data.getData().get(position).getType().equals("Annual Leave")&&Data.getData().get(position).getStatus().equals("Approved")) {
                vh.tagleave.setImageResource(R.drawable.tagal);
                vh.txtname.setTextColor(Color.parseColor("#2ECC71"));
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);


            } else if  (Data.getData().get(position).getType().equals("Annual Leave")&&Data.getData().get(position).getStatus().equals("Endorsed")) {
                vh.tagleave.setImageResource(R.drawable.tagal);
                vh.txtname.setTextColor(Color.parseColor("#0059F3"));
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);


            } else if (Data.getData().get(position).getType().equals("Medical Leave")&&Data.getData().get(position).getStatus().equals("Approved")) {
                vh.tagleave.setImageResource(R.drawable.tagml);
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#2ECC71"));

            }else if (Data.getData().get(position).getType().equals("Medical Leave")&&Data.getData().get(position).getStatus().equals("Pending")) {
                vh.tagleave.setImageResource(R.drawable.tagml);
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#C1C1C1"));

            }else if (Data.getData().get(position).getType().equals("Medical Leave")&&Data.getData().get(position).getStatus().equals("Endorsed")) {
                vh.tagleave.setImageResource(R.drawable.tagml);
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#1E58BE"));

            } else if (Data.getData().get(position).getType().equals("Unpaid Leave")&&Data.getData().get(position).getStatus().equals("Approved")) {
                vh.tagleave.setImageResource(R.drawable.tagul);
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#2ECC71"));

            } else if (Data.getData().get(position).getType().equals("Unpaid Leave")&&Data.getData().get(position).getStatus().equals("Pending")) {
                vh.tagleave.setImageResource(R.drawable.tagul);
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#C1C1C1"));

            } else if (Data.getData().get(position).getType().equals("Unpaid Leave")&&Data.getData().get(position).getStatus().equals("Endorsed")) {
                vh.tagleave.setImageResource(R.drawable.tagul);
                vh.txtholiday.setVisibility(View.GONE);
                vh.text25.setVisibility(View.GONE);
                vh.text26.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#1E58BE"));

            }
        }
            else {
            vh.tagleave.setVisibility(View.GONE);
            vh.text19.setVisibility(View.GONE);
            vh.text21.setVisibility(View.GONE);
            vh.txtdaytype.setVisibility(View.GONE);
            vh.text25.setVisibility(View.GONE);
            vh.text26.setVisibility(View.GONE);
            vh.txtholiday.setText(Data.getData().get(position).getHoliday());
        }

        if(Data.getData().get(position).getLeaveType() != null ){

            if (Data.getData().get(position).getLeaveType().equals("EmergencyLeave")&&Data.getData().get(position).getStatus().equals("Approved")) {
                vh.tagleave.setImageResource(R.drawable.tagel);
                vh.txtdaytype.setText(Data.getData().get(position).getDayType());
                vh.txtdaytype.setTextColor(Color.parseColor("#2ECC71"));
                vh.txtholiday.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#2ECC71"));


            } else if (Data.getData().get(position).getLeaveType().equals("EmergencyLeave")&&Data.getData().get(position).getStatus().equals("Pending")) {
                vh.tagleave.setImageResource(R.drawable.tagel);
                vh.txtdaytype.setText(Data.getData().get(position).getDayType());
                vh.txtdaytype.setTextColor(Color.parseColor("#2ECC71"));
                vh.txtholiday.setVisibility(View.GONE);
                vh.txtname.setTextColor(Color.parseColor("#C1C1C1"));


            } else if (Data.getData().get(position).getLeaveType().equals("EmergencyLeave")&&Data.getData().get(position).getStatus().equals("Endorsed")) {
                vh.tagleave.setImageResource(R.drawable.tagel);
                vh.txtdaytype.setText(Data.getData().get(position).getDayType());
                vh.txtdaytype.setTextColor(Color.parseColor("#2ECC71"));
                vh.txtholiday.setVisibility(View.GONE);
                Log.e("emergency",Data.getData().get(position).getLeaveType());
                vh.txtname.setTextColor(Color.parseColor("#1E58BE"));


            }

            else {
                vh.tagleave.setVisibility(View.GONE);
                vh.text19.setVisibility(View.GONE);
                vh.text21.setVisibility(View.GONE);
                vh.txtholiday.setText(Data.getData().get(position).getHoliday());
            }

        }

        vh.txtname.setText(Data.getData().get(position).getName());
        vh.txtreliefstaff.setText(Data.getData().get(position).getReliefStaff());


        return view;

        //save product id to tag
    }

}


