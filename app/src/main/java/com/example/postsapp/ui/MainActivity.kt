package com.example.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.postsapp.R
import com.example.postsapp.repository.PostsRepository
import com.example.postsapp.viewModel.PostsViewModel
import com.example.postsapp.viewModel.PostsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postsRepository=PostsRepository()
        postsViewModelFactory=PostsViewModelFactory(postsRepository)
        postsViewModel=
            ViewModelProvider(this ,postsViewModelFactory).get(PostsViewModel::class.java)
        postsViewModel.getPosts()
        postsViewModel.postsLiveData.observe(this, Observer { postsList->

            if (Posts.isEmpty()){
                postsViewModel.getApiPosts()
            }
            else{
                val postsAdapter=PostsAdapters(posts,)

            }
        })
        postsViewModel.postsFailedLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })

    }
}
