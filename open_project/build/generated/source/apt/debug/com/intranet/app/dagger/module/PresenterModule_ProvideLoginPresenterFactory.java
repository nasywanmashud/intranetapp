package com.intranet.app.dagger.module;

import android.content.Context;
import com.intranet.app.ui.Presenter.LoginPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PresenterModule_ProvideLoginPresenterFactory implements Factory<LoginPresenter> {
  private final PresenterModule module;

  private final Provider<Context> contextProvider;

  public PresenterModule_ProvideLoginPresenterFactory(
      PresenterModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public LoginPresenter get() {
    return Preconditions.checkNotNull(
        module.provideLoginPresenter(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoginPresenter> create(
      PresenterModule module, Provider<Context> contextProvider) {
    return new PresenterModule_ProvideLoginPresenterFactory(module, contextProvider);
  }

  /** Proxies {@link PresenterModule#provideLoginPresenter(Context)}. */
  public static LoginPresenter proxyProvideLoginPresenter(
      PresenterModule instance, Context context) {
    return instance.provideLoginPresenter(context);
  }
}
