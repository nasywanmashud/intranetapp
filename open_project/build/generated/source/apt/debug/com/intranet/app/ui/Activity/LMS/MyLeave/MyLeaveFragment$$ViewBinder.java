// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MyLeaveFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.LMS.MyLeave.MyLeaveFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296526, "field 'btnlms'");
    target.btnlms = finder.castView(view, 2131296526, "field 'btnlms'");
    view = finder.findRequiredView(source, 2131296305, "field 'btnal'");
    target.btnal = finder.castView(view, 2131296305, "field 'btnal'");
    view = finder.findRequiredView(source, 2131296557, "field 'btnml'");
    target.btnml = finder.castView(view, 2131296557, "field 'btnml'");
    view = finder.findRequiredView(source, 2131296787, "field 'btnul'");
    target.btnul = finder.castView(view, 2131296787, "field 'btnul'");
  }

  @Override public void unbind(T target) {
    target.btnlms = null;
    target.btnal = null;
    target.btnml = null;
    target.btnul = null;
  }
}
