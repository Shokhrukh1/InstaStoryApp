package tk.opensourcedevelopment.instastoryapp.ui.video.di

import dagger.Binds
import dagger.Module
import tk.opensourcedevelopment.instastoryapp.ui.video.VideoActivity

@Module
interface VideoActivityModule {
    @Binds
    fun provideVidoeView(activity: VideoActivity): VideoView

    @Binds
    fun provideVideoPresenter(presenter: VideoPresenterImpl): VideoPresenter
}