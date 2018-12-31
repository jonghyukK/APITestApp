package com.trebit.restapitest.ui.arraydata

import android.arch.lifecycle.MutableLiveData
import android.telephony.euicc.DownloadableSubscription
import com.trebit.restapitest.base.BaseViewModel
import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ArrayDataViewModel : BaseViewModel() {

    private val userRepository = UserRepository()

    var mUserLists: MutableLiveData<List<UserVo>> = MutableLiveData()
    private lateinit var mSubscription: Disposable


    fun getUserList() {

        mSubscription = userRepository.getUserList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })


    }


}
