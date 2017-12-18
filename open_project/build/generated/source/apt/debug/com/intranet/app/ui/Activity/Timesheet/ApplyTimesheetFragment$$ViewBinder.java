// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Timesheet;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ApplyTimesheetFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Timesheet.ApplyTimesheetFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296573, "field 'btnnewentry'");
    target.btnnewentry = finder.castView(view, 2131296573, "field 'btnnewentry'");
    view = finder.findRequiredView(source, 2131296404, "field 'txtdate'");
    target.txtdate = finder.castView(view, 2131296404, "field 'txtdate'");
  }

  @Override public void unbind(T target) {
    target.btnnewentry = null;
    target.txtdate = null;
  }
}
