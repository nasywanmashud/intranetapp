package com.intranet.app.ui.Activity.Pop;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Presenter.LoginPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * This class allow user to log in the app
 */
public class PopFragment extends BaseFragment  {



    @Inject
    LoginPresenter presenter;

    @Inject
    Bus bus;

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


    @Bind(R.id.Name)
    TextView txtName;

    @Bind(R.id.btnClose)
    Button close;

    private SharedPrefManager pref;

    public static PopFragment newInstance(Bundle bundle) {

        PopFragment fragment = new PopFragment();
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

        View view = inflater.inflate(R.layout.activity_pop, container, false);
        ButterKnife.bind(this, view);

        pref = new SharedPrefManager(getActivity());


        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        String date = bundle.getString("date");
        String clock_in1 = bundle.getString("clock_in1");
        String clock_out1 = bundle.getString("clock_out1");
        String clock_in2 = bundle.getString("clock_in2");
        String clock_out2 = bundle.getString("clock_out2");
        String total_hours = bundle.getString("total_hours");

        txtName.setText(name);
        txtDate.setText(date);
        txtClock_in1.setText(clock_in1);
        txtClock_out1.setText(clock_out1);
        txtClock_in2.setText(clock_in2);
        txtClock_out2.setText(clock_out2);
        txtTotal_hours.setText(total_hours);


        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getActivity().getWindow().setLayout((int)(width*.7),(int)(height*.7));


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

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
