package kg.tutorial.genericapiclient.models.restApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object {
        const val BASE_URL = "https://official-joke-api.appspot.com/"

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val retrofitData = retrofitBuilder!!
    }
}