package com.intranet.app.ui.Activity.LMS;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Receive.Records;
import com.intranet.app.ui.Presenter.LoginPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * This class allow user to log in the app
 */
public class LeaveAppResultFragment extends BaseFragment  {



    @Inject
    LoginPresenter presenter;

    @Inject
    Bus bus;

    //String  appstatus;

    @Bind(R.id.appstatus)
    Spinner spinappstatus;

    ArrayList<String>leaveapplist = new ArrayList<String>();

    //String [] appstatus={"All" , "leave" , "credit"} ;

    private SharedPrefManager pref;

    public static LeaveAppListFragment newInstance(Bundle bundle) {

        LeaveAppListFragment fragment = new LeaveAppListFragment();
        // Bundle args = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RealmObjectController.clearCachedResult(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_leaveapplist, container, false);
        ButterKnife.bind(this, view);

        pref = new SharedPrefManager(getActivity());

        Bundle bundle = getArguments();





        return view;


    }


    @Override
    public void onResume() {
        super.onResume();
        //  presenter.onResume();
//        bus.register(this);

        RealmResults<CachedResult> result = RealmObjectController.getCachedResult(MainFragmentActivity.getContext());
        if (result.size() > 0) {

            Gson gson = new Gson();
            if (result.get(0).getCachedAPI() != null) {
                if (result.get(0).getCachedAPI().equals("UserLogin")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    LoginReceive obj = gson.fromJson(result.get(0).getCachedResult(), LoginReceive.class);

                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());


                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //  presenter.onPause();
        //   bus.unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}

