package com.example.relaxx.ui.home

import android.app.Activity
import com.example.relaxx.injections.ApplicationComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainComponent {

    fun inject(homeViewModel: HomeViewModel)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: Activity): Builder

        fun appComponent(applicationComponent: ApplicationComponent): Builder

        fun build(): MainComponent
    }

}