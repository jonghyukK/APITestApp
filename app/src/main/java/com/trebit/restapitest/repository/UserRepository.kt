package com.trebit.restapitest.repository

import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.remote.RESTClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * RestAPITest
 * Class: UserRepository
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class UserRepository {

    private val mApiInterface = RESTClient.create()

    fun getUserList(): Observable<List<UserVo>> = mApiInterface.getUserList()

}