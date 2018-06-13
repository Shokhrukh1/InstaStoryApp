package tk.opensourcedevelopment.instastoryapp.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.FullScreenImageActivity
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.di.FullScreenImageActivityModule
import tk.opensourcedevelopment.instastoryapp.ui.login.LoginActivity
import tk.opensourcedevelopment.instastoryapp.ui.login.di.LoginActivityModule
import tk.opensourcedevelopment.instastoryapp.ui.story.StoryActivity
import tk.opensourcedevelopment.instastoryapp.ui.story.di.StoryActivityModule
import tk.opensourcedevelopment.instastoryapp.ui.video.VideoActivity
import tk.opensourcedevelopment.instastoryapp.ui.video.di.VideoActivityModule
import tk.opensourcedevelopment.instastoryapp.ui.welcome.WelcomeActivity
import tk.opensourcedevelopment.instastoryapp.ui.welcome.di.WelcomeActivityModule

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [(WelcomeActivityModule::class)])
    fun bindWelcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector(modules = [(StoryActivityModule::class)])
    fun bindStoryActivity(): StoryActivity

    @ContributesAndroidInjector(modules = [(FullScreenImageActivityModule::class)])
    fun bindFullScreenImageActivity(): FullScreenImageActivity

    @ContributesAndroidInjector(modules = [(VideoActivityModule::class)])
    fun bindVideoActivity(): VideoActivity
}