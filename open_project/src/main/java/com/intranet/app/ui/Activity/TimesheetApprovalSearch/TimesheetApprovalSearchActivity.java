package com.intranet.app.ui.Activity.TimesheetApprovalSearch;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalFragment;

import butterknife.ButterKnife;

public class TimesheetApprovalSearchActivity extends MainFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, TimesheetApprovalSearchFragment.newInstance(bundle)).commit();

        //setActionbar_normal_title("Sample App");
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


