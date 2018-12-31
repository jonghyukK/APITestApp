package com.trebit.restapitest.service

import com.trebit.restapitest.model.PagedListConnectionResponse
import com.trebit.restapitest.model.UserVo

/**
 * RestAPITest
 * Class: DataService
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

interface DataService {

    fun loadUsers(limit: Int = 20,
                  after: String? = null,
                  callback: (PagedListConnectionResponse<UserVo>) -> Unit)

    fun getUserById(id: String, callback: (UserVo?) -> Unit)


}