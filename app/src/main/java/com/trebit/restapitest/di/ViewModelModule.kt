package com.trebit.restapitest.di

import com.trebit.restapitest.repository.UserRepository
import com.trebit.restapitest.ui.login.LoginViewModel
import com.trebit.restapitest.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * RestAPITest
 * Class: ViewModelModule
 * Created by kangjonghyuk on 20/01/2019.
 *
 * Description:
 */

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideLoginViewModel(repository        : UserRepository,
                              schedulerProvider : SchedulerProvider
    ): LoginViewModel = LoginViewModel(repository, schedulerProvider)
}