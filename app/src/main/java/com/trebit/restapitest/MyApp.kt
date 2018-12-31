package com.trebit.restapitest

import android.app.Application
import com.trebit.restapitest.repository.ContentsRepository
import com.trebit.restapitest.service.DataService
import com.trebit.restapitest.service.MockDataService
import com.trebit.restapitest.ui.arraydata.ArrayDataViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * RestAPITest
 * Class: MyApp
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class MyApp: Application() {

    companion object {

        private val servicesModule: Module = applicationContext {
            bean { MockDataService() as DataService }
        }

        private val repositoriesModule: Module = applicationContext {
            bean { ContentsRepository( get()) }
        }

        private val viewModelsModule: Module = applicationContext {
            viewModel { ArrayDataViewModel(get()) }
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(servicesModule, repositoriesModule, viewModelsModule))
    }
}