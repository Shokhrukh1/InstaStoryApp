package tk.opensourcedevelopment.instastoryapp.ui.welcome.di

import dagger.Binds
import dagger.Module
import tk.opensourcedevelopment.instastoryapp.ui.welcome.WelcomeActivity

@Module
interface WelcomeActivityModule {
    @Binds
    fun provideWelcomeView(activity: WelcomeActivity): WelcomeView

    @Binds
    fun provideWelcome(presenter: WelcomePresenterImpl): WelcomePresenter
}