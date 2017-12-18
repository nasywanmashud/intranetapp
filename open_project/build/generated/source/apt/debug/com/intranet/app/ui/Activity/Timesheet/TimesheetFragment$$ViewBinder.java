// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Timesheet;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TimesheetFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Timesheet.TimesheetFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296343, "field 'materialCalendarView'");
    target.materialCalendarView = finder.castView(view, 2131296343, "field 'materialCalendarView'");
  }

  @Override public void unbind(T target) {
    target.materialCalendarView = null;
  }
}
