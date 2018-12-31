package com.trebit.restapitest.model

/**
 * RestAPITest
 * Class: ContentsVo
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

data class ContentsVo(val profileImg: String,   // Profile Path
                      val userId    : String,   // User ID
                      val imgPath   : String,   // Image Path
                      val heartCount: Int,      // Heart Count
                      val dataText  : String,   // Contents Text
                      val createDate: String    // Create Date
)