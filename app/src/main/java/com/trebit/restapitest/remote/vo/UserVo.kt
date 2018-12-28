package com.trebit.restapitest.remote.vo

/**
 * RestAPITest
 * Class: UserVo
 * Created by kangjonghyuk on 24/12/2018.
 *
 * Description:
 */

//
//data class UserVo(val item: List<UserVo12>)
//
//
//data class UserVo12(val str: Map<String, UserVo1>)
//
//
//data class UserVo1(
//    val id: String,
//    val name: String
//)
//
//data class UserVo22(val id: String, val pw: String, val pw_confirm: String)
//
//
//data class TestUserVo(val userLists: List<UserVo22>)


/**********************************************************************************


Test


 ***********************************************************************************/


data class UserVo(
    val id: String,
    val pw1: String,
    val pw2: String
)