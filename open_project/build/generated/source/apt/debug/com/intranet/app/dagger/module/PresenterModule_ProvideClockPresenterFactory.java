package com.intranet.app.dagger.module;

import android.content.Context;
import com.intranet.app.ui.Presenter.ClockPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PresenterModule_ProvideClockPresenterFactory implements Factory<ClockPresenter> {
  private final PresenterModule module;

  private final Provider<Context> contextProvider;

  public PresenterModule_ProvideClockPresenterFactory(
      PresenterModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public ClockPresenter get() {
    return Preconditions.checkNotNull(
        module.provideClockPresenter(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ClockPresenter> create(
      PresenterModule module, Provider<Context> contextProvider) {
    return new PresenterModule_ProvideClockPresenterFactory(module, contextProvider);
  }

  /** Proxies {@link PresenterModule#provideClockPresenter(Context)}. */
  public static ClockPresenter proxyProvideClockPresenter(
      PresenterModule instance, Context context) {
    return instance.provideClockPresenter(context);
  }
}
