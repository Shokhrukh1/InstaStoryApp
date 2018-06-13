package tk.opensourcedevelopment.instastoryapp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import tk.opensourcedevelopment.instastoryapp.InstaApp
import tk.opensourcedevelopment.instastoryapp.di.builder.ActivityBuilder
import tk.opensourcedevelopment.instastoryapp.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: InstaApp)
}