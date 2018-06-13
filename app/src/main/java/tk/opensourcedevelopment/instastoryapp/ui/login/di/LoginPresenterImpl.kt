package tk.opensourcedevelopment.instastoryapp.ui.login.di

import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tk.opensourcedevelopment.instastoryapp.data.preferences.PreferenceHelper
import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenterImpl
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(view: LoginView, val instagram: Instagram4Android, val preferenceHelper: PreferenceHelper) : BasePresenterImpl<LoginView>(view), LoginPresenter {
    override fun checkUserLoggedIn() {
        if (preferenceHelper.isUserLoggedIn()) {
            login(preferenceHelper.getUserName(), preferenceHelper.getPassword())
        }
    }

    override fun login(userName: String, password: String) {
        view.showProgressBar()

        Observable.create<InstagramLoginResult> {
            instagram.username = userName
            instagram.password = password

            instagram.setup()
            it.onNext(instagram.login())
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.status == "ok") {
                        preferenceHelper.setUserLoggedIn(true)
                        preferenceHelper.setUserName(instagram.username)
                        preferenceHelper.setPassword(instagram.password)

                        view.openWelcomeActivity()
                    } else {
                        view.hideProgressBar()
                        view.showMessage(it.message)
                    }
                }, {

                })
    }
}