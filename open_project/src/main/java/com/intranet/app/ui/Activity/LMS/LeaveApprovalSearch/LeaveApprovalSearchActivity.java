package com.intranet.app.ui.Activity.LMS.LeaveApprovalSearch;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment;

import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/28/2017.
 */

public class LeaveApprovalSearchActivity extends MainFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, LeaveApprovalSearchFragment.newInstance(bundle)).commit();

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    //@Override
    //public int getFragmentContainerId() {
    //return R.id.main_activity_fragment_container;
    //}
}


