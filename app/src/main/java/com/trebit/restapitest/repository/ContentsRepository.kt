package com.trebit.restapitest.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.trebit.restapitest.remote.ApiInterface
import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.service.DataService
import io.reactivex.Observable

/**
 * RestAPITest
 * Class: ContentsRepository
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class ContentsRepository(dataService: DataService) {
    val pagedList: LiveData<PagedList<UserVo>>
    private val dataSource: LiveData<UserDataSource>

    init {
        val sourceFactory= UserDataSourceFactory(dataService)
        dataSource = sourceFactory.currentDataSource
        pagedList = LivePagedListBuilder(sourceFactory, 20).build()
    }

    fun getUserById(id: String, callback: (UserVo?) -> Unit) = dataSource.value?.getUserById(id, callback)


}