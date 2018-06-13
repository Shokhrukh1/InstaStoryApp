package tk.opensourcedevelopment.instastoryapp.ui.login.di

import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenter

interface LoginPresenter : BasePresenter {
    fun checkUserLoggedIn()
    fun login(userName: String, password: String)
}