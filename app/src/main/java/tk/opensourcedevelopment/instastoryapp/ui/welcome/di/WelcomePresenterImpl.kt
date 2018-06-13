package tk.opensourcedevelopment.instastoryapp.ui.welcome.di

import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.InstagramSearchUsersRequest
import dev.niekirk.com.instagram4android.requests.payload.InstagramSearchUsersResult
import io.reactivex.Observable
import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenterImpl
import javax.inject.Inject

class WelcomePresenterImpl @Inject constructor(view: WelcomeView, val instagram: Instagram4Android) : BasePresenterImpl<WelcomeView>(view), WelcomePresenter {
    override fun searchUser(userName: String): Observable<InstagramSearchUsersResult> {
        return Observable.create<InstagramSearchUsersResult> {
            it.onNext(instagram.sendRequest(InstagramSearchUsersRequest(userName)))
        }
    }
}