package com.trebit.restapitest.ui.arraydata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trebit.restapitest.R
import com.trebit.restapitest.adapter.ContentsAdapter
import com.trebit.restapitest.toast
import kotlinx.android.synthetic.main.fragment_array_data.*
import org.koin.android.architecture.ext.viewModel

class ArrayDataFragment : Fragment() {

    companion object {
        fun newInstance() = ArrayDataFragment()
    }

    private val viewModel by viewModel<ArrayDataViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_array_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(ArrayDataViewModel::class.java)

        val adapter = ContentsAdapter { userVo ->
            toast(context!!, "Clicked $userVo.id")
        }

        array_recyclerView.adapter = adapter

        viewModel.userList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

}
