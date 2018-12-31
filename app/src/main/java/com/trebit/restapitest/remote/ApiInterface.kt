package com.trebit.restapitest.remote

import com.trebit.restapitest.model.UserVo
import io.reactivex.Observable
import retrofit2.http.*

/**
 * RestAPITest
 * Class: ApiInterface
 * Created by kangjonghyuk on 24/12/2018.
 *
 * Description:
 */

interface ApiInterface {

    @GET("user")
    fun getUserList(): Observable<List<UserVo>>


    @GET("user/selectUserById")
    fun selectUserById(
        @Query("id") id: String
    ): Observable<UserVo>

    @GET("user/checkLogin")
    fun checkLogin(
        @Query("id") id: String,
        @Query("pw") pw: String
    ): Observable<String>


    @GET("user/createUser")
    fun createUser(
        @Query("id") id  : String,
        @Query("pw1") pw1: String,
        @Query("pw2") pw2: String
    ): Observable<UserVo>


}