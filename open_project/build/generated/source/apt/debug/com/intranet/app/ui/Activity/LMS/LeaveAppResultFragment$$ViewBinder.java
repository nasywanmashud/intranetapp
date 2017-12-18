// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LeaveAppResultFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.LeaveAppResultFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296319, "field 'spinappstatus'");
    target.spinappstatus = finder.castView(view, 2131296319, "field 'spinappstatus'");
  }

  @Override public void unbind(T target) {
    target.spinappstatus = null;
  }
}
