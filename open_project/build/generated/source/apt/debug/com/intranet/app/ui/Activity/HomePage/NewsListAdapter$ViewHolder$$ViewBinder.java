// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.HomePage;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewsListAdapter$ViewHolder$$ViewBinder<T extends com.intranet.app.ui.Activity.HomePage.NewsListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296279, "field 'txtabstract'");
    target.txtabstract = finder.castView(view, 2131296279, "field 'txtabstract'");
    view = finder.findRequiredView(source, 2131296757, "field 'txttitle'");
    target.txttitle = finder.castView(view, 2131296757, "field 'txttitle'");
  }

  @Override public void unbind(T target) {
    target.txtabstract = null;
    target.txttitle = null;
  }
}
