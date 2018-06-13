package tk.opensourcedevelopment.instastoryapp.ui.story.di

import dagger.Binds
import dagger.Module
import tk.opensourcedevelopment.instastoryapp.ui.story.StoryActivity

@Module
interface StoryActivityModule {
    @Binds
    fun provideStoryView(activity: StoryActivity): StoryView

    @Binds
    fun provideStoryPresenter(presenter: StoryPresenterImpl): StoryPresenter
}