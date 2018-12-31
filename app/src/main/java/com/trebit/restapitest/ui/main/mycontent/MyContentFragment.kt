package com.trebit.restapitest.ui.main.mycontent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trebit.restapitest.R

class MyContentFragment : Fragment() {

    companion object {
        fun newInstance() = MyContentFragment()
    }

    private lateinit var viewModel: MyContentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_my_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyContentViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
