// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LeaveCalendarAdapter$ViewHolder$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.LeaveCalendarAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296268, "field 'txtname'");
    target.txtname = finder.castView(view, 2131296268, "field 'txtname'");
    view = finder.findRequiredView(source, 2131296271, "field 'txtreliefstaff'");
    target.txtreliefstaff = finder.castView(view, 2131296271, "field 'txtreliefstaff'");
    view = finder.findRequiredView(source, 2131296699, "field 'tagleave'");
    target.tagleave = finder.castView(view, 2131296699, "field 'tagleave'");
    view = finder.findRequiredView(source, 2131296728, "field 'text19'");
    target.text19 = finder.castView(view, 2131296728, "field 'text19'");
    view = finder.findRequiredView(source, 2131296781, "field 'txtdaytype'");
    target.txtdaytype = finder.castView(view, 2131296781, "field 'txtdaytype'");
    view = finder.findRequiredView(source, 2131296731, "field 'text21'");
    target.text21 = finder.castView(view, 2131296731, "field 'text21'");
    view = finder.findRequiredView(source, 2131296736, "field 'text26'");
    target.text26 = finder.castView(view, 2131296736, "field 'text26'");
    view = finder.findRequiredView(source, 2131296735, "field 'text25'");
    target.text25 = finder.castView(view, 2131296735, "field 'text25'");
    view = finder.findRequiredView(source, 2131296465, "field 'txtholiday'");
    target.txtholiday = finder.castView(view, 2131296465, "field 'txtholiday'");
  }

  @Override public void unbind(T target) {
    target.txtname = null;
    target.txtreliefstaff = null;
    target.tagleave = null;
    target.text19 = null;
    target.txtdaytype = null;
    target.text21 = null;
    target.text26 = null;
    target.text25 = null;
    target.txtholiday = null;
  }
}
