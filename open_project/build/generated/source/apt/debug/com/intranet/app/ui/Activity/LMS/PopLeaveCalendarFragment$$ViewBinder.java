// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PopLeaveCalendarFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.PopLeaveCalendarFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296338, "field 'close'");
    target.close = finder.castView(view, 2131296338, "field 'close'");
    view = finder.findRequiredView(source, 2131296522, "field 'listView'");
    target.listView = finder.castView(view, 2131296522, "field 'listView'");
  }

  @Override public void unbind(T target) {
    target.close = null;
    target.listView = null;
  }
}
