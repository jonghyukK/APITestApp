package com.trebit.restapitest.adapter

import android.arch.paging.PagedListAdapter
import android.os.Build.VERSION_CODES.N
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trebit.restapitest.R
import com.trebit.restapitest.model.UserVo
import kotlinx.android.synthetic.main.layout_array_contents.view.*

/**
 * RestAPITest
 * Class: ContentsAdapter
 * Created by kangjonghyuk on 31/12/2018.
 *
 * Description:
 */

class ContentsAdapter(val onClick: (UserVo) -> Unit) : PagedListAdapter<UserVo, ContentsAdapter.ContentsViewHolder>(USER_COMPARATOR) {

    companion object {
        private val USER_COMPARATOR = object: DiffUtil.ItemCallback<UserVo>() {
            override fun areItemsTheSame(p0: UserVo, p1: UserVo): Boolean = p0.id == p1.id
            override fun areContentsTheSame(p0: UserVo, p1: UserVo): Boolean = p0 == p1
        }
    }

    override fun onBindViewHolder(holder: ContentsViewHolder, position: Int) {
        holder.uservo = getItem(position)
        holder.view.setOnClickListener { onClick(holder.uservo!!)}
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContentsViewHolder {
        return ContentsViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.layout_array_contents, p0, false)
        )
    }

    class ContentsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var uservo: UserVo? = null
            set(value) {
                field = value
                view.tv_testString.text = value?.id ?: "undefined"
            }
    }
}
