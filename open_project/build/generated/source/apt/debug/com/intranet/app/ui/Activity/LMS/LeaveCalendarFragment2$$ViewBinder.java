// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LeaveCalendarFragment2$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment2> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296514, "field 'listView'");
    target.listView = finder.castView(view, 2131296514, "field 'listView'");
    view = finder.findRequiredView(source, 2131296677, "field 'txtstaff'");
    target.txtstaff = finder.castView(view, 2131296677, "field 'txtstaff'");
    view = finder.findRequiredView(source, 2131296343, "field 'materialCalendarView'");
    target.materialCalendarView = finder.castView(view, 2131296343, "field 'materialCalendarView'");
    view = finder.findRequiredView(source, 2131296703, "field 'btn'");
    target.btn = finder.castView(view, 2131296703, "field 'btn'");
    view = finder.findRequiredView(source, 2131296510, "field 'btnlegen'");
    target.btnlegen = finder.castView(view, 2131296510, "field 'btnlegen'");
  }

  @Override public void unbind(T target) {
    target.listView = null;
    target.txtstaff = null;
    target.materialCalendarView = null;
    target.btn = null;
    target.btnlegen = null;
  }
}
