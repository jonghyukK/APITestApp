package com.trebit.restapitest

import android.content.Context
import android.widget.Toast

/**
 * RestAPITest
 * Class: Commons
 * Created by kangjonghyuk on 28/12/2018.
 *
 * Description:
 */


fun toast(ctx: Context, msg: String) {
    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
}