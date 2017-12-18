// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AnnualLeaveListAdapter$ViewHolder$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.MyLeave.AnnualLeaveListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296614, "field 'txtrefno'");
    target.txtrefno = finder.castView(view, 2131296614, "field 'txtrefno'");
    view = finder.findRequiredView(source, 2131296315, "field 'txtapplieddate'");
    target.txtapplieddate = finder.castView(view, 2131296315, "field 'txtapplieddate'");
    view = finder.findRequiredView(source, 2131296506, "field 'txtleavetype'");
    target.txtleavetype = finder.castView(view, 2131296506, "field 'txtleavetype'");
    view = finder.findRequiredView(source, 2131296414, "field 'txtdatefrom'");
    target.txtdatefrom = finder.castView(view, 2131296414, "field 'txtdatefrom'");
    view = finder.findRequiredView(source, 2131296417, "field 'txtdays'");
    target.txtdays = finder.castView(view, 2131296417, "field 'txtdays'");
    view = finder.findRequiredView(source, 2131296616, "field 'txtreliefstaff'");
    target.txtreliefstaff = finder.castView(view, 2131296616, "field 'txtreliefstaff'");
    view = finder.findRequiredView(source, 2131296682, "field 'txtstatus'");
    target.txtstatus = finder.castView(view, 2131296682, "field 'txtstatus'");
    view = finder.findRequiredView(source, 2131296678, "field 'txtstaffremarks'");
    target.txtstaffremarks = finder.castView(view, 2131296678, "field 'txtstaffremarks'");
    view = finder.findRequiredView(source, 2131296415, "field 'txtdateto'");
    target.txtdateto = finder.castView(view, 2131296415, "field 'txtdateto'");
    view = finder.findRequiredView(source, 2131296697, "field 'img'");
    target.img = finder.castView(view, 2131296697, "field 'img'");
  }

  @Override public void unbind(T target) {
    target.txtrefno = null;
    target.txtapplieddate = null;
    target.txtleavetype = null;
    target.txtdatefrom = null;
    target.txtdays = null;
    target.txtreliefstaff = null;
    target.txtstatus = null;
    target.txtstaffremarks = null;
    target.txtdateto = null;
    target.img = null;
  }
}
