package com.trebit.restapitest.model

/**
 * RestAPITest
 * Class: PagedListConnectionResponse
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

data class PagedListConnectionResponse<out T>(val items: List<T>, val nextToken: String?)