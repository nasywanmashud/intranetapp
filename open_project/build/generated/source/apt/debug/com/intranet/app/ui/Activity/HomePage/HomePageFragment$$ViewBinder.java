// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.HomePage;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomePageFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.HomePage.HomePageFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296333, "field 'btnAttendance'");
    target.btnAttendance = finder.castView(view, 2131296333, "field 'btnAttendance'");
    view = finder.findRequiredView(source, 2131296523, "field 'lvNews'");
    target.lvNews = finder.castView(view, 2131296523, "field 'lvNews'");
  }

  @Override public void unbind(T target) {
    target.btnAttendance = null;
    target.lvNews = null;
  }
}
