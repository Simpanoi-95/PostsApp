package com.example.postsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.models.Post
import com.example.postsapp.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel (val postsRepository: PostsRepository):ViewModel(){
    val postsLiveData=MutableLiveData<List<Post>>()
    val postsFailedLiveData= MutableLiveData<String>()

    fun getPosts(){
        viewModelScope.launch{
            val response=postsRepository.getPosts()
            if(response.isSuccessful){
                postsLiveData.postValue(response.body())
            }
            else{
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}




