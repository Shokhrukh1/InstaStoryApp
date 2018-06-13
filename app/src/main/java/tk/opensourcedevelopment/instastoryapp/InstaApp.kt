package tk.opensourcedevelopment.instastoryapp

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import tk.opensourcedevelopment.instastoryapp.di.component.DaggerAppComponent
import javax.inject.Inject

class InstaApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector() = activityDispatchingAndroidInjector
}