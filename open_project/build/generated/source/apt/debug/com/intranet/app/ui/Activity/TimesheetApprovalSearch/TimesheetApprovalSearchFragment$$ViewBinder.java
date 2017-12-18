// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.TimesheetApprovalSearch;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TimesheetApprovalSearchFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.TimesheetApprovalSearch.TimesheetApprovalSearchFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296406, "field 'tvdatefrom'");
    target.tvdatefrom = finder.castView(view, 2131296406, "field 'tvdatefrom'");
    view = finder.findRequiredView(source, 2131296489, "field 'imgfrom'");
    target.imgfrom = finder.castView(view, 2131296489, "field 'imgfrom'");
    view = finder.findRequiredView(source, 2131296490, "field 'imgto'");
    target.imgto = finder.castView(view, 2131296490, "field 'imgto'");
    view = finder.findRequiredView(source, 2131296408, "field 'tvdateto'");
    target.tvdateto = finder.castView(view, 2131296408, "field 'tvdateto'");
    view = finder.findRequiredView(source, 2131296637, "field 'btnsearch'");
    target.btnsearch = finder.castView(view, 2131296637, "field 'btnsearch'");
    view = finder.findRequiredView(source, 2131296598, "field 'spinproject'");
    target.spinproject = finder.castView(view, 2131296598, "field 'spinproject'");
    view = finder.findRequiredView(source, 2131296700, "field 'spintask'");
    target.spintask = finder.castView(view, 2131296700, "field 'spintask'");
    view = finder.findRequiredView(source, 2131296316, "field 'txtapprover'");
    target.txtapprover = finder.castView(view, 2131296316, "field 'txtapprover'");
    view = finder.findRequiredView(source, 2131296682, "field 'spinstatus'");
    target.spinstatus = finder.castView(view, 2131296682, "field 'spinstatus'");
    view = finder.findRequiredView(source, 2131296269, "field 'spinot'");
    target.spinot = finder.castView(view, 2131296269, "field 'spinot'");
    view = finder.findRequiredView(source, 2131296676, "field 'spinstaff'");
    target.spinstaff = finder.castView(view, 2131296676, "field 'spinstaff'");
  }

  @Override public void unbind(T target) {
    target.tvdatefrom = null;
    target.imgfrom = null;
    target.imgto = null;
    target.tvdateto = null;
    target.btnsearch = null;
    target.spinproject = null;
    target.spintask = null;
    target.txtapprover = null;
    target.spinstatus = null;
    target.spinot = null;
    target.spinstaff = null;
  }
}
