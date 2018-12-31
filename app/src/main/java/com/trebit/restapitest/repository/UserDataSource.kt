package com.trebit.restapitest.repository

import android.arch.paging.PageKeyedDataSource
import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.service.DataService

/**
 * RestAPITest
 * Class: UserDataSource
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class UserDataSource(private val dataService: DataService) : PageKeyedDataSource<String, UserVo>() {

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, UserVo>) {
        dataService.loadUsers(params.requestedLoadSize, null) {response ->
            callback.onResult(response.items, null, response.nextToken)
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, UserVo>) {
        dataService.loadUsers(params.requestedLoadSize, params.key) { response ->
            callback.onResult(response.items, response.nextToken)
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, UserVo>) {
        invalidate()
    }

    fun getUserById(id: String, callback: (UserVo?) -> Unit) = dataService.getUserById(id, callback)
}