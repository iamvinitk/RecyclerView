package com.example.recyclerview.activities

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import com.example.recyclerview.R
import com.example.recyclerview.adapters.UserAdapter
import com.example.recyclerview.objects.User

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null
    private val users = ArrayList<User>()
    private var userAdapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        progressBar = findViewById(R.id.progress_bar)
        userAdapter = UserAdapter(this, users)
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.adapter = userAdapter
        progressBar!!.visibility = View.VISIBLE
        FetchDataAsyncTask().execute()
        Toast.makeText(this, "Its working", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("StaticFieldLeak")
    inner class FetchDataAsyncTask : AsyncTask<Any, Any, ArrayList<User>>() {

        override fun doInBackground(objects: Array<Any>): ArrayList<User> {
            // Make your database calls here. It will run in background.
            val userArrayList = ArrayList<User>()
            userArrayList.add(User("User 1", "user1@gmail.com"))
            userArrayList.add(User("User 2", "user2@gmail.com"))
            userArrayList.add(User("User 3", "user3@gmail.com"))
            userArrayList.add(User("User 4", "user4@gmail.com"))
            userArrayList.add(User("User 5", "user5@gmail.com"))
            userArrayList.add(User("User 6", "user6@gmail.com"))
            userArrayList.add(User("User 7", "user7@gmail.com"))
            userArrayList.add(User("User 8", "user8@gmail.com"))
            userArrayList.add(User("User 9", "user9@gmail.com"))
            userArrayList.add(User("User 10", "user10@gmail.com"))

            return userArrayList
        }

        override fun onPostExecute(leaderBoards: ArrayList<User>) {
            if (leaderBoards.size > 0) {
                users.addAll(leaderBoards)
                userAdapter!!.notifyDataSetChanged()
            }

            progressBar!!.visibility = View.INVISIBLE
        }
    }
}
