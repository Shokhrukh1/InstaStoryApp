package tk.opensourcedevelopment.instastoryapp.ui.story.di

import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.InstagramUserStoryFeedRequest
import dev.niekirk.com.instagram4android.requests.payload.InstagramUserStoryFeedResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenterImpl
import javax.inject.Inject

class StoryPresenterImpl @Inject constructor(view: StoryView, val instagram: Instagram4Android) : BasePresenterImpl<StoryView>(view), StoryPresenter {
    override fun getStories(userId: Long) {
        Observable.create<InstagramUserStoryFeedResult> {
            /*val result = instagram.sendRequest(InstagramReelsTrayRequest())
            val trays = result.getTray()*/

            //val userStories = ArrayList<InstagramUserStoryFeedResult>()

            /*for (tray in trays) {
                if (tray != null) {*/
            //userStories.add(instagram.sendRequest(InstagramUserStoryFeedRequest("$userId")))
            /*  }
          }*/
            it.onNext(instagram.sendRequest(InstagramUserStoryFeedRequest("$userId")))


            /*if (stories.getReel() != null) {
                stories.getReel().get
            } else {

            }*/
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.getReel() != null)
                        view.showStories(it.getReel().items)
                }
    }
}