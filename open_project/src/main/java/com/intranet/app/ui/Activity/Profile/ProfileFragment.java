package com.intranet.app.ui.Activity.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;


/**
 * Created by Me-Tech on 9/28/2017.
 */

public class ProfileFragment extends BaseFragment{

    @Inject
    Bus bus;


    @Bind(R.id.imageView3)
    ImageView imgprofilepicture;


    @Bind(R.id.username)
    TextView txtusername;



//    @Bind(R.id.img)
//    ImageView imgprofilepicture;


    @Bind(R.id.fullname)
    TextView txtfullname;

    @Bind(R.id.email)
    TextView txtemail;

    @Bind(R.id.phonenumber)
    TextView txtphonenumber;

    @Bind(R.id.icnumber)
    TextView txticnumber;



    @Inject
    ClockPresenter presenter;

    private SharedPrefManager pref;

    public static ProfileFragment newInstance(Bundle bundle) {

        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
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

        View view = inflater.inflate(R.layout.activity_profile, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        pref = new SharedPrefManager(getActivity());



//        HashMap<String, String> image = pref.getImage();
//        final String img = image.get(SharedPrefManager.IMAGE);
//        Glide.with(this).load("https://intranet.me-tech.com.my" + img).into(imgprofilepicture);


        HashMap<String, String> image = pref.getImage();
        final String img = image.get(SharedPrefManager.IMAGE);

        Glide.with(this).load("https://intranet.me-tech.com.my" + img).into(imgprofilepicture);


        HashMap<String, String> username = pref.getUsername();
        final String name = username.get(SharedPrefManager.USERNAME);
        txtusername.setText(name);


        HashMap<String, String> fullName = pref.getFullName();
        final String fname = fullName.get(SharedPrefManager.FULLNAME);
        txtfullname.setText(fname);

        HashMap<String, String> email = pref.getEmail();
        final String eemail = email.get(SharedPrefManager.EMAIL);
        txtemail.setText(eemail);

        HashMap<String, String> phonenumber = pref.getPhoneNumber();
        final String phoneno = phonenumber.get(SharedPrefManager.PHONENUMBER);
        txtphonenumber.setText(phoneno);

        HashMap<String, String> icnumber = pref.getIcNumber();
        final String icno = icnumber.get(SharedPrefManager.ICNUMBER);
        txticnumber.setText(icno);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        bus.register(this);

        RealmResults<CachedResult> result = RealmObjectController.getCachedResult(MainFragmentActivity.getContext());
        if (result.size() > 0) {

            Gson gson = new Gson();
            if (result.get(0).getCachedAPI() != null) {
                if (result.get(0).getCachedAPI().equals("Clock")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    ClockReceive obj = gson.fromJson(result.get(0).getCachedResult(), ClockReceive.class);
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        bus.unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}

