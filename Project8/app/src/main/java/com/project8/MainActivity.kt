package com.project8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)


        val flowersData = listOf(
            Pair("Peony", "https://rivne1.tv/pics2/2004/i112912.jpg?1587209023"),
            Pair("Orchid","http://img.ukrbio.com/data/articles/img/4802/orhideya.jpg"),
            Pair("Viola","http://img.ukrbio.com/data/articles/img/4802/fialka.jpg"),
            Pair("Lily","http://img.ukrbio.com/data/articles/img/4802/naikrasivishi_kviti_v_sviti.jpg"),
            Pair("Rose","http://img.ukrbio.com/data/articles/img/4802/troyanda.jpg"),
            Pair("Tulip","http://img.ukrbio.com/data/articles/img/4802/tulpan.jpg"),
            Pair("Lotus","http://img.ukrbio.com/data/articles/img/4802/lotos.jpg"),

        )

        val adapter = FlowersAdapter(flowersData){
            position -> Toast.makeText(this, flowersData[position].first, Toast.LENGTH_LONG).show()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}