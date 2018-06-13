package tk.opensourcedevelopment.instastoryapp.ui.login.di

import dagger.Binds
import dagger.Module
import tk.opensourcedevelopment.instastoryapp.ui.login.LoginActivity

@Module
interface LoginActivityModule {
    @Binds
    fun provideLoginView(activity: LoginActivity): LoginView

    @Binds
    fun provideLoginPresenter(presenter: LoginPresenterImpl): LoginPresenter
}