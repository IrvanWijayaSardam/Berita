package com.aminivan.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aminivan.berita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapterNews: AdapterNews
    lateinit var vmNews: ViewModelNews
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycle()

        vmNews = ViewModelProvider(this).get(ViewModelNews::class.java)
        vmNews.getNews()
        vmNews.beritaList.observe(this, Observer {
            adapterNews.setDataNews(it as ArrayList<ListNews>)
        })
    }

    fun setRecycle(){
        adapterNews = AdapterNews(ArrayList())


        binding.rvNews.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvNews.adapter = adapterNews
    }

}