package com.trebit.restapitest.ui.login

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.trebit.restapitest.repository.UserRepository
import com.trebit.restapitest.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel (
    private val repository         : UserRepository,
    private val schedulersProvider : SchedulerProvider
){

    private val compositeDisposable by lazy { CompositeDisposable() }

    var loginValid: MutableLiveData<Boolean> = MutableLiveData()


    /**
     *  Login시 ID, PW Check API
     */
    fun checkLoginInfo(id: String, pw: String) {
        compositeDisposable.add(
            repository.checkLogin(id = id, pw = pw)
                .compose(schedulersProvider.getSchedulersForSingle())
                .subscribe(
                    {
                        loginValid.value = it == "MATCH"
                    },
                    {
                        loginValid.value = false
                        Log.d("TTT", "error : ${it.message}")
                    }
                )
        )
    }

}
