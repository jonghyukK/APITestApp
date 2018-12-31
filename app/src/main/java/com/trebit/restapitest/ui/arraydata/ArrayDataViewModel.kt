package com.trebit.restapitest.ui.arraydata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.trebit.restapitest.base.BaseViewModel
import com.trebit.restapitest.model.UserVo
import com.trebit.restapitest.repository.ContentsRepository

class ArrayDataViewModel(contentsRepository: ContentsRepository)
    : BaseViewModel() {

    val userList: LiveData<PagedList<UserVo>> = contentsRepository.pagedList


}
