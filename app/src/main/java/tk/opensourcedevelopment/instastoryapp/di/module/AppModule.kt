package tk.opensourcedevelopment.instastoryapp.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dev.niekirk.com.instagram4android.Instagram4Android
import tk.opensourcedevelopment.instastoryapp.data.preferences.AppPreferenceHelper
import tk.opensourcedevelopment.instastoryapp.data.preferences.PreferenceHelper
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideInstagram() : Instagram4Android = Instagram4Android.builder().build()

    @Provides
    @Singleton
    fun providePrefHelper(context: Context): PreferenceHelper = AppPreferenceHelper(context)
}