package com.trebit.restapitest.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.trebit.restapitest.R
import com.trebit.restapitest.ui.arraydata.ArrayDataFragment
import com.trebit.restapitest.ui.main.addcontent.AddContentFragment
import com.trebit.restapitest.ui.main.allcontent.AllContentFragment
import com.trebit.restapitest.ui.main.mycontent.MyContentFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        addFragment(AllContentFragment.newInstance())
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_first -> {
                addFragment(AllContentFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_second -> {
                addFragment(AddContentFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_third -> {
                addFragment(MyContentFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }




}
