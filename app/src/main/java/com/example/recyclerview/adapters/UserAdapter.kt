package com.example.recyclerview.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.recyclerview.R
import com.example.recyclerview.objects.User

import java.util.ArrayList

class UserAdapter(private var context: Context?, private val users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val menuItemLayoutView = LayoutInflater.from(parent.context).inflate(
                R.layout.row_template, parent, false)
        return UserHolder(menuItemLayoutView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userHolder = holder as UserHolder

        val serialNo = position.toString()
        val userName = users[position].userName
        val userEmail = users[position].userEmail

        userHolder.serialNo.text = serialNo
        userHolder.userName.text = userName
        userHolder.userEmail.text = userEmail

    }

    override fun getItemCount(): Int {
        return users.size
    }

    private inner class UserHolder internal constructor(v: View) : RecyclerView.ViewHolder(v) {
        internal var serialNo: TextView
        internal var userName: TextView
        internal var userEmail: TextView

        init {
            context = v.context
            serialNo = v.findViewById(R.id.serial_no)
            userEmail = v.findViewById(R.id.user_email)
            userName = v.findViewById(R.id.username)
        }
    }
}