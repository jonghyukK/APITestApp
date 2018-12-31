package com.trebit.restapitest.service

import android.util.Log
import com.trebit.restapitest.model.PagedListConnectionResponse
import com.trebit.restapitest.model.UserVo

/**
 * RestAPITest
 * Class: MockDataService
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class MockDataService: DataService {

    private val items = ArrayList<UserVo>()

    init {
        for ( i in 1 .. 3000) {
            val item = UserVo("user $i", "pw1 $i", "pw2 $i")
            items.add(item)
        }
    }

    override fun loadUsers(limit: Int,
                           after: String?,
                           callback: (PagedListConnectionResponse<UserVo>) -> Unit) {
        Log.d("TTT", "loadItems($limit, \"$after\")")

        var firstItem = 0
        if (after != null) {
            firstItem = items.indexOfFirst { userVo -> userVo.id == after }
            if ( firstItem < 0 ) {
                callback(PagedListConnectionResponse(emptyList(), null))
                Log.d("TTT", "test1")
            }
            firstItem++
        }

        Log.d("TTT", "loadItems(): firstItem = $firstItem, items.size = ${items.size}")
        if (firstItem > items.size -1 ) {
            callback(PagedListConnectionResponse(emptyList(), null))
            Log.d("TTT", "loadItems(): asking for beyond end - return empty list")
            return
        }

        val nItems = minOf(limit, items.size - firstItem)
        Log.d("TTT", "loadItems(): nItems = $nItems")
        if ( nItems == 0) {
            Log.d("TTT", "loadItems(): no items, so return empty list")
                callback(PagedListConnectionResponse(emptyList(), null))
            return
        }
        val sublist = items.subList(firstItem, firstItem + nItems).toList()
        val nextToken: String? = if ( firstItem + nItems - 1 == items.size) null
        else sublist.last().id
        Log.d("TTT", "loadItems(): returning ${sublist.size} items, nextToken = $nextToken")
        callback(PagedListConnectionResponse(sublist,nextToken))
    }
}