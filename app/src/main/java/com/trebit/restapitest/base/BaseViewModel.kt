package com.trebit.restapitest.base

import android.arch.lifecycle.ViewModel
import com.trebit.restapitest.remote.RESTClient

/**
 * RestAPITest
 * Class: BaseViewModel
 * Created by kangjonghyuk on 28/12/2018.
 *
 * Description:
 */

open class BaseViewModel: ViewModel() {
    open val mApiInterface = RESTClient.create()
}