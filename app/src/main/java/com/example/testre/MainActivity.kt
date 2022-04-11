package com.example.testre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ret.MyRetrofit
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler:RecyclerView = findViewById(R.id.rec)
        val ret = MyRetrofit().getRetrofit()
        val interf = ret.create(MyInterface::class.java)
        val  call = interf.postLogin()
                .enqueue(object : retrofit2.Callback<feelings> {
                    override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                        recycler.adapter = RecyclerAdapter(this@MainActivity, response.body()!!)
                    }

                    override fun onFailure(call: Call<feelings>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                })
    }
}
