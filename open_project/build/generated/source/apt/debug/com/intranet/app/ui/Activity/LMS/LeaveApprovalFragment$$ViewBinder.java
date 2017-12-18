// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LeaveApprovalFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131296336, "field 'btnsearch2'");
    target.btnsearch2 = finder.castView(view, 2131296336, "field 'btnsearch2'");
    view = finder.findRequiredView(source, 2131296524, "field 'listView'");
    target.listView = finder.castView(view, 2131296524, "field 'listView'");
  }

  @Override public void unbind(T target) {
    target.tvdatefrom = null;
    target.imgfrom = null;
    target.imgto = null;
    target.tvdateto = null;
    target.btnsearch = null;
    target.btnsearch2 = null;
    target.listView = null;
  }
}
