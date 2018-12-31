package com.trebit.restapitest.ui.main.allcontent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.trebit.restapitest.R

class AllContentFragment : Fragment() {

    companion object {
        fun newInstance() = AllContentFragment()
    }

    private lateinit var viewModel: AllContentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllContentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
