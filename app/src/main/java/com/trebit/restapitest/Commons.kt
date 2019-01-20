package com.trebit.restapitest

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * RestAPITest
 * Class: Commons
 * Created by kangjonghyuk on 28/12/2018.
 *
 * Description:
 */


const val BASE_URL = "http://192.168.122.15:8080/"



inline fun Context.toast(message: () -> String) {
    Toast.makeText(this, message(), Toast.LENGTH_SHORT).show()
}



//inline fun AppCompatActivity.replaceFragment(id: Int, frag: () -> Fragment) {
//
//    supportFragmentManager.beginTransaction()
//        .replace(id, frag)
//        .addToBackStack(null)
//        .commit()
//
//}
