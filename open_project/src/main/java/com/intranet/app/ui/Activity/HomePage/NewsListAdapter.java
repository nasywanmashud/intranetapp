package com.intranet.app.ui.Activity.HomePage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.intranet.app.R;
import com.intranet.app.ui.Model.Receive.NewsReceive;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class NewsListAdapter extends BaseAdapter {

    private Activity mContext;

    NewsReceive Details;

    public NewsListAdapter(Activity mContext,  NewsReceive DetailList) {
        this.mContext = mContext;
        this.Details = DetailList;
    }

    @Override
    public int getCount() {
        return Details.getDetails().size();
        //return Details.get(0).getDetails().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getDetails().get(position);
        //return Details.get(position).getDetails().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        @Bind(R.id.absract)
        TextView txtabstract;

        @Bind(R.id.title)
        TextView txttitle;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_news_list, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        //Set text for TextView
        vh.txttitle.setText(Details.getDetails().get(position).getTitle());
        vh.txtabstract.setText(Details.getDetails().get(position).getAbstract());

       // vh.txttitle.setText(Details.get(position).getDetails().get(position).getTitle());
        //vh.txtabstract.setText(Details.get(position).getDetails().get(position).getAbstract());


        return view;

        //save product id to tag
    }

}


