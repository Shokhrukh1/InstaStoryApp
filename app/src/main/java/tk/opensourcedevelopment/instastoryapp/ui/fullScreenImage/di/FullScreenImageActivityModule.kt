package tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.di

import dagger.Binds
import dagger.Module
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.FullScreenImageActivity

@Module
interface FullScreenImageActivityModule {
    @Binds
    fun provideImageView(activityFullScreen: FullScreenImageActivity): FullScreenImageView

    @Binds
    fun provideImagePresenter(presenter: FullScreenImagePresenterImpl): FullScreenImagePresenter
}