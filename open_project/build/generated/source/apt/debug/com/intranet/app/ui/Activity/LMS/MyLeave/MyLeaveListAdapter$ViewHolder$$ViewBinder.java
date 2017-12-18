// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MyLeaveListAdapter$ViewHolder$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.MyLeave.MyLeaveListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296506, "field 'txtleavetype'");
    target.txtleavetype = finder.castView(view, 2131296506, "field 'txtleavetype'");
    view = finder.findRequiredView(source, 2131296332, "field 'txtbroughtforward'");
    target.txtbroughtforward = finder.castView(view, 2131296332, "field 'txtbroughtforward'");
    view = finder.findRequiredView(source, 2131296312, "field 'txtannualEntitlement'");
    target.txtannualEntitlement = finder.castView(view, 2131296312, "field 'txtannualEntitlement'");
    view = finder.findRequiredView(source, 2131296257, "field 'txtAdhocEntitlement'");
    target.txtAdhocEntitlement = finder.castView(view, 2131296257, "field 'txtAdhocEntitlement'");
    view = finder.findRequiredView(source, 2131296774, "field 'txttotal'");
    target.txttotal = finder.castView(view, 2131296774, "field 'txttotal'");
    view = finder.findRequiredView(source, 2131296505, "field 'txtleavetaken'");
    target.txtleavetaken = finder.castView(view, 2131296505, "field 'txtleavetaken'");
    view = finder.findRequiredView(source, 2131296397, "field 'txtcreditapproved'");
    target.txtcreditapproved = finder.castView(view, 2131296397, "field 'txtcreditapproved'");
    view = finder.findRequiredView(source, 2131296327, "field 'txtbalance'");
    target.txtbalance = finder.castView(view, 2131296327, "field 'txtbalance'");
  }

  @Override public void unbind(T target) {
    target.txtleavetype = null;
    target.txtbroughtforward = null;
    target.txtannualEntitlement = null;
    target.txtAdhocEntitlement = null;
    target.txttotal = null;
    target.txtleavetaken = null;
    target.txtcreditapproved = null;
    target.txtbalance = null;
  }
}
