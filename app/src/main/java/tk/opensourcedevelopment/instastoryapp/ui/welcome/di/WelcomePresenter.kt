package tk.opensourcedevelopment.instastoryapp.ui.welcome.di

import dev.niekirk.com.instagram4android.requests.payload.InstagramSearchUsersResult
import io.reactivex.Observable
import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenter

interface WelcomePresenter : BasePresenter {
    fun searchUser(userName: String): Observable<InstagramSearchUsersResult>
}