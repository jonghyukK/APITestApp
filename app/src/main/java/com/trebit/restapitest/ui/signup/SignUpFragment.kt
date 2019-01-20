package com.trebit.restapitest.ui.signup

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.trebit.restapitest.R
import com.trebit.restapitest.databinding.FragmentSignUpBinding
import com.trebit.restapitest.toast
import com.trebit.restapitest.ui.login.LoginActivity

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    var inputId  : String = ""
    var inputPw1 : String = ""
    var inputPw2 : String = ""
    private lateinit var mContext  : Context
    private lateinit var viewModel : SignUpViewModel
    private lateinit var mBinding  : FragmentSignUpBinding

    override fun onCreateView(inflater           : LayoutInflater,
                              container          : ViewGroup?,
                              savedInstanceState : Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        mBinding.fragment = this

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        mContext = activity!!.baseContext
//        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        viewModel.apiResult.observe(this, Observer {
            (activity as LoginActivity).showAlert(it?.id)
        })

        viewModel.apiError.observe(this, Observer {
            mContext.toast { it!! }
        })
    }


    /**
     *  가입하기 버튼 Event
     */
    fun onReqSignUp(v: View)
    {
        val inputState = if (inputId.isEmpty() || inputPw1.isEmpty() || inputPw2.isEmpty()) {
            State.EMPTY
        } else if (inputPw1 != inputPw2) {
            State.NOT_MATCH
        } else {
            State.MATCH
        }

        when (inputState) {
            State.EMPTY     -> mContext.toast { "find Empty Things. check Thins." }
            State.NOT_MATCH -> mContext.toast { "PW1 and PW2 not equals, check pw1 and pw2" }
//            State.MATCH     -> viewModel.requestSignUp(inputId, inputPw1, inputPw2)
        }
    }


    /**
     *  취소 버튼 Event
     */
    fun onCancel(v: View) {
        activity?.onBackPressed()
    }


    enum class State {
        EMPTY,
        NOT_MATCH,
        MATCH
    }
}
