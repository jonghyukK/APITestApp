package com.trebit.restapitest.ui.onedata

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.trebit.restapitest.R

class OneDataFragment : Fragment() {

    companion object {
        fun newInstance() = OneDataFragment()
    }

    private lateinit var viewModel: OneDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OneDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
