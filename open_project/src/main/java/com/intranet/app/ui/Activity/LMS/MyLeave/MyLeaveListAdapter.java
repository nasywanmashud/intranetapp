package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.intranet.app.R;
import com.intranet.app.ui.Model.Receive.MyLeaveReceive;
import com.intranet.app.ui.Model.Receive.NewsReceive;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class MyLeaveListAdapter extends BaseAdapter {

    private Activity mContext;

    MyLeaveReceive Details;

    public MyLeaveListAdapter(Activity mContext, MyLeaveReceive DetailList) {
        this.mContext = mContext;
        this.Details = DetailList;
    }

    @Override
    public int getCount() {
        return Details.getLeaveType().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getLeaveType().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{

        @Bind(R.id.leavetype)
        TextView txtleavetype;

        @Bind(R.id.broughtforward)
        TextView txtbroughtforward;

        @Bind(R.id.annualEntitlement)
        TextView txtannualEntitlement;

        @Bind(R.id.AdhocEntitlement)
        TextView txtAdhocEntitlement;

        @Bind(R.id.total)
        TextView txttotal;

        @Bind(R.id.leavetaken)
        TextView txtleavetaken;

        @Bind(R.id.creditapproved)
        TextView txtcreditapproved;

        @Bind(R.id.balance)
        TextView txtbalance;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_myleavelist, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        //Set text for TextView
        vh.txtAdhocEntitlement.setText(Details.getLeaveType().get(position).getAdhocEntitlement());
        vh.txtannualEntitlement.setText(Details.getLeaveType().get(position).getAnnualEntitlement());
        vh.txtbalance.setText(Details.getLeaveType().get(position).getBalance());
        vh.txtbroughtforward.setText(Details.getLeaveType().get(position).getBroughtForward());
        vh.txtcreditapproved.setText(Details.getLeaveType().get(position).getCreditApproved());
        vh.txtleavetaken.setText(Details.getLeaveType().get(position).getLeaveTaken());
        vh.txtleavetype.setText(Details.getLeaveType().get(position).getLeaveType());
        vh.txttotal.setText(Details.getLeaveType().get(position).getTotal());
        return view;

        //save product id to tag
    }

}


