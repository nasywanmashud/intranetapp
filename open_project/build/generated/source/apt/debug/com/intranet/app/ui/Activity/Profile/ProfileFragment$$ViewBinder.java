// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Profile;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ProfileFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Profile.ProfileFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296481, "field 'imgprofilepicture'");
    target.imgprofilepicture = finder.castView(view, 2131296481, "field 'imgprofilepicture'");
    view = finder.findRequiredView(source, 2131296793, "field 'txtusername'");
    target.txtusername = finder.castView(view, 2131296793, "field 'txtusername'");
    view = finder.findRequiredView(source, 2131296462, "field 'txtfullname'");
    target.txtfullname = finder.castView(view, 2131296462, "field 'txtfullname'");
    view = finder.findRequiredView(source, 2131296437, "field 'txtemail'");
    target.txtemail = finder.castView(view, 2131296437, "field 'txtemail'");
    view = finder.findRequiredView(source, 2131296591, "field 'txtphonenumber'");
    target.txtphonenumber = finder.castView(view, 2131296591, "field 'txtphonenumber'");
    view = finder.findRequiredView(source, 2131296473, "field 'txticnumber'");
    target.txticnumber = finder.castView(view, 2131296473, "field 'txticnumber'");
  }

  @Override public void unbind(T target) {
    target.imgprofilepicture = null;
    target.txtusername = null;
    target.txtfullname = null;
    target.txtemail = null;
    target.txtphonenumber = null;
    target.txticnumber = null;
  }
}
