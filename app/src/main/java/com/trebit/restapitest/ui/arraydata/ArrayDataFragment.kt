package com.trebit.restapitest.ui.arraydata

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trebit.restapitest.R

class ArrayDataFragment : Fragment() {

    companion object {
        fun newInstance() = ArrayDataFragment()
    }

    private lateinit var viewModel: ArrayDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_array_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArrayDataViewModel::class.java)




    }

}
