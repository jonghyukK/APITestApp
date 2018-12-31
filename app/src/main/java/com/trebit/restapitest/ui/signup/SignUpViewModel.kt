package com.trebit.restapitest.ui.signup

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SignUpViewModel : BaseViewModel() {

    var apiResult: MutableLiveData<UserVo> = MutableLiveData()
    var apiError : MutableLiveData<String> = MutableLiveData()
    private lateinit var mSubscription: Disposable

    fun requestSignUp(id  : String,
                      pw1 : String,
                      pw2 : String
    ){
        mSubscription = mApiInterface.createUser(id = id, pw1 = pw1, pw2 = pw2)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            apiResult.value = it
                        }, {
                            apiError.value = it.message
                        })
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("TTT", "onCleared Called")
        if(this::mSubscription.isInitialized)
            mSubscription.dispose()
    }
}
