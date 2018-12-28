package com.trebit.restapitest.ui.login

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.trebit.restapitest.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel : BaseViewModel(){

    var loginValid: MutableLiveData<Boolean> = MutableLiveData()
    private lateinit var mSubscription: Disposable


    /**
     *  Login시 ID, PW Check API
     */
    fun checkLoginInfo(id: String, pw: String) {
        mSubscription = mApiInterface.checkLogin(id, pw)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { loginValid.value = it == "MATCH" },
                {
                    loginValid.value = false
                    Log.d("TTT", "error : ${it.message}")
                }
            )
    }


    override fun onCleared() {
        super.onCleared()

        if(this::mSubscription.isInitialized)
            mSubscription.dispose()
    }


}
