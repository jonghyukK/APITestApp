package com.trebit.restapitest.ui.login

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.trebit.restapitest.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (savedInstanceState == null)
            initFragment()

    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment.newInstance())
            .commitNow()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun showAlert(id: String?) {
        AlertDialog.Builder(this)
            .setTitle("Success SignUp")
            .setMessage("Success SignUp, $id!! \n please Login...")
            .setPositiveButton("Confirm") { _,_ ->
                onBackPressed()
            }
            .create()
            .show()
    }
}
