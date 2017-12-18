// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Pop;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PopFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Pop.PopFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296262, "field 'txtDate'");
    target.txtDate = finder.castView(view, 2131296262, "field 'txtDate'");
    view = finder.findRequiredView(source, 2131296364, "field 'txtClock_in1'");
    target.txtClock_in1 = finder.castView(view, 2131296364, "field 'txtClock_in1'");
    view = finder.findRequiredView(source, 2131296366, "field 'txtClock_out1'");
    target.txtClock_out1 = finder.castView(view, 2131296366, "field 'txtClock_out1'");
    view = finder.findRequiredView(source, 2131296365, "field 'txtClock_in2'");
    target.txtClock_in2 = finder.castView(view, 2131296365, "field 'txtClock_in2'");
    view = finder.findRequiredView(source, 2131296367, "field 'txtClock_out2'");
    target.txtClock_out2 = finder.castView(view, 2131296367, "field 'txtClock_out2'");
    view = finder.findRequiredView(source, 2131296775, "field 'txtTotal_hours'");
    target.txtTotal_hours = finder.castView(view, 2131296775, "field 'txtTotal_hours'");
    view = finder.findRequiredView(source, 2131296268, "field 'txtName'");
    target.txtName = finder.castView(view, 2131296268, "field 'txtName'");
    view = finder.findRequiredView(source, 2131296334, "field 'close'");
    target.close = finder.castView(view, 2131296334, "field 'close'");
  }

  @Override public void unbind(T target) {
    target.txtDate = null;
    target.txtClock_in1 = null;
    target.txtClock_out1 = null;
    target.txtClock_in2 = null;
    target.txtClock_out2 = null;
    target.txtTotal_hours = null;
    target.txtName = null;
    target.close = null;
  }
}
