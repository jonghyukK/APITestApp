package com.trebit.restapitest.di

import android.net.Network
import com.trebit.restapitest.ui.login.LoginActivity
import com.trebit.restapitest.ui.login.LoginFragment
import dagger.Component
import javax.inject.Singleton

/**
 * RestAPITest
 * Class: AppComponent
 * Created by kangjonghyuk on 20/01/2019.
 *
 * Description:
 */

@Component(modules = [
    NetworkModule::class,
    ViewModelModule::class
])
@Singleton
interface AppComponent {
    fun inject(activity: LoginFragment)
}