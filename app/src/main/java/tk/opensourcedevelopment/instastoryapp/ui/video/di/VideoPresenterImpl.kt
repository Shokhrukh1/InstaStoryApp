package tk.opensourcedevelopment.instastoryapp.ui.video.di

import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenterImpl
import javax.inject.Inject

class VideoPresenterImpl @Inject constructor(view: VideoView) : BasePresenterImpl<VideoView>(view), VideoPresenter {
}