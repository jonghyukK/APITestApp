package com.trebit.restapitest.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trebit.restapitest.R
import com.trebit.restapitest.databinding.LoginFragmentBinding
import com.trebit.restapitest.toast
import com.trebit.restapitest.ui.signup.SignUpFragment
import com.trebit.restapitest.ui.main.MainActivity

class LoginFragment : Fragment(){

    companion object {
        fun newInstance() = LoginFragment()
    }

    var inputId = ""
    var inputPw = ""
    private lateinit var mContext : Context
    private lateinit var viewModel: LoginViewModel
    private lateinit var mBinding : LoginFragmentBinding

    override fun onCreateView(
        inflater           : LayoutInflater,
        container          : ViewGroup?,
        savedInstanceState : Bundle?
    ): View {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        mBinding.loginFragment = this

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = activity!!.baseContext
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.loginValid.observe(this, Observer {

            if ( it == true )
                startActivity(Intent(mContext, MainActivity::class.java))
            else toast(mContext, "Login Failed")
        })
    }


    /**
     *  Login Button Event
     */
    fun onPressedLogin(v: View) {
        if (inputId.isEmpty() || inputPw.isEmpty()) {
            toast(mContext, "input ID or PW")
            return
        } else {
            viewModel.checkLoginInfo(inputId, inputPw)
        }
    }

    /**
     *  Sign Up Button Event
     */
    fun onPressedSignUp(v: View) {
        if (activity is LoginActivity) {
            (activity as LoginActivity).replaceFragment(SignUpFragment.newInstance())
        }
    }
}
