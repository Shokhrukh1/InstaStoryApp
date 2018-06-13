package tk.opensourcedevelopment.instastoryapp.ui.video.di

import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseView

interface VideoView : BaseView {
    fun playVideo(url: String)
}