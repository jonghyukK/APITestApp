package com.trebit.restapitest.repository

import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.remote.ApiInterface
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * RestAPITest
 * Class: UserRepository
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

@Singleton
class UserRepository @Inject constructor(
    private val apiInterface: ApiInterface
){


    fun checkLogin(id: String,
                   pw: String
    ): Single<String>
            = apiInterface.checkLogin(id = id, pw = pw)



    fun getUserList(): Single<List<UserVo>>
            = apiInterface.getUserList()



    fun selectUserById(id: String
    ): Single<UserVo>
            = apiInterface.selectUserById(id)


    fun createUser(id  : String,
                   pw1 : String,
                   pw2 : String
    ): Single<UserVo>
            = apiInterface.createUser(id = id, pw1 = pw1, pw2 = pw2)






}