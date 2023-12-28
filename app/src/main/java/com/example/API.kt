package com.example

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//{
//    "userId": 1,
//    "id": 1,
//    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
//}
data class Data(
    val userId : Int,
    val id : Int,
    val title : String,
    val body : String
)
object API {

    val api : ApiService

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
         api = retrofit.create(ApiService::class.java)
    }

    suspend fun getData(){
        val call = api.getTopHeadlines("title")
        Log.e("bharagav", call.status.toString())
    }



}