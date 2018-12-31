package com.trebit.restapitest.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.trebit.restapitest.ui.main.allcontent.AllContentFragment
import com.trebit.restapitest.ui.main.addcontent.AddContentFragment
import com.trebit.restapitest.ui.main.mycontent.MyContentFragment

/**
 * RestAPITest
 * Class: MainPagerAdapter
 * Created by kangjonghyuk on 28/12/2018.
 *
 * Description:
 */

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment = when (position) {
        0    -> AllContentFragment.newInstance()
        1    -> AddContentFragment.newInstance()
        else -> MyContentFragment.newInstance()
    }


    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0    -> "First"
        1    -> "Second"
        else -> "Third"
    }

}