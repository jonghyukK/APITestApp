package com.trebit.restapitest

import android.app.Application
import com.trebit.restapitest.di.AppComponent
import com.trebit.restapitest.di.DaggerAppComponent

/**
 * RestAPITest
 * Class: App
 * Created by kangjonghyuk on 20/01/2019.
 *
 * Description:
 */


class App : Application() {


    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = buildComponent()
    }

    private fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .build()
    }
}