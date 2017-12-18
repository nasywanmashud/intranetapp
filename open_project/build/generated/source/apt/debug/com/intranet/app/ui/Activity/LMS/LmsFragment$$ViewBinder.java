// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LmsFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.LmsFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296504, "field 'leaveapp'");
    target.leaveapp = finder.castView(view, 2131296504, "field 'leaveapp'");
  }

  @Override public void unbind(T target) {
    target.leaveapp = null;
  }
}
