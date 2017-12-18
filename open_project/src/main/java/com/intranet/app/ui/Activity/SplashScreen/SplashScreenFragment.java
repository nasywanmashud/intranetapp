package com.intranet.app.ui.Activity.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarAdapter;
import com.intranet.app.ui.Activity.Login.LoginActivity;
import com.intranet.app.ui.Activity.NavTest.Main3Activity;
import com.intranet.app.ui.Model.Receive.Data;
import com.intranet.app.ui.Model.Receive.LeaveCalendarReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * This class allow user to log in the app
 */
public class SplashScreenFragment extends BaseFragment  {


    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

    private static int SPLASH_TIME_OUT = 4000;
    private SharedPrefManager pref;

    public static SplashScreenFragment newInstance(Bundle bundle) {

        SplashScreenFragment fragment = new SplashScreenFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.component(getActivity()).inject(this);
        RealmObjectController.clearCachedResult(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_welcomescreen, container, false);
        ButterKnife.bind(this, view);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                initiateLoading(getActivity());

//               Intent next = new Intent(Welcomescreen.this, LoginActivity.class);
//               startActivity(next);
//               finish();
                pref = new SharedPrefManager(getActivity());

                HashMap<String, String> loginstatus = pref.getLoginStatus();
                final String lstatus = loginstatus.get(SharedPrefManager.LOGINSTATUS);

                if(lstatus != null){

                    if (lstatus.equals("true")) {
                        Intent next = new Intent(getActivity(), Main3Activity.class);
                        startActivity(next);
                        getActivity().finish();
                    }
                    else {
                        Intent next = new Intent(getActivity(), LoginActivity.class);
                        startActivity(next);

                    }

                }else {

                    Intent next = new Intent(getActivity(), LoginActivity.class);
                    startActivity(next);

                }


            }
        },SPLASH_TIME_OUT);


        return view;


    }
    @Override
    public void onResume() {
        super.onResume();
//        presenter.onResume();
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
//        presenter.onPause();
//        bus.unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
