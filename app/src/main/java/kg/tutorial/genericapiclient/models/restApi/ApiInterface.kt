package kg.tutorial.genericapiclient.models.restApi

import kg.tutorial.genericapiclient.models.data.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("random_ten")
    fun getData(): Call<List<MyDataItem>>
}