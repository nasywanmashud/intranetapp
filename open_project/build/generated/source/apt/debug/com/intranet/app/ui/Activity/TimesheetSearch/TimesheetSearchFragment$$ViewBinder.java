// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.TimesheetSearch;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TimesheetSearchFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296521, "field 'listView'");
    target.listView = finder.castView(view, 2131296521, "field 'listView'");
    view = finder.findRequiredView(source, 2131296685, "field 'spinappstatusall'");
    target.spinappstatusall = finder.castView(view, 2131296685, "field 'spinappstatusall'");
    view = finder.findRequiredView(source, 2131296683, "field 'spinstatus1'");
    target.spinstatus1 = finder.castView(view, 2131296683, "field 'spinstatus1'");
  }

  @Override public void unbind(T target) {
    target.listView = null;
    target.spinappstatusall = null;
    target.spinstatus1 = null;
  }
}
