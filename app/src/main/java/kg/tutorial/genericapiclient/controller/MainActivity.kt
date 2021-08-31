package kg.tutorial.genericapiclient.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kg.tutorial.genericapiclient.databinding.ActivityMainBinding
import kg.tutorial.genericapiclient.models.data.MyDataItem
import kg.tutorial.genericapiclient.models.restApi.ApiInterface
import kg.tutorial.genericapiclient.models.restApi.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = linearLayoutManager

        getMyData()

        binding.btnUpdate.setOnClickListener {
            getMyData()
        }
    }

    private fun getMyData() {
        val apiService = ApiService.retrofitData.create(ApiInterface::class.java)
        apiService.getData().enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!
                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.rv.adapter = myAdapter
            }
            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                //d("MainActivity", "onFailure: "+t.message)
            }
        })
    }
}

