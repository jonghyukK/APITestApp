package com.trebit.restapitest.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.service.DataService

/**
 * RestAPITest
 * Class: UserDataSourceFactory
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class UserDataSourceFactory(private val dataService: DataService): DataSource.Factory<String, UserVo>() {

    private val mDataSource = MutableLiveData<UserDataSource>()
    val currentDataSource: LiveData<UserDataSource> = mDataSource

    override fun create(): DataSource<String, UserVo> {
        val dataSource = UserDataSource(dataService)
        mDataSource.postValue(dataSource)
        return dataSource

    }
}