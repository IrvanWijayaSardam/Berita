package com.aminivan.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aminivan.berita.databinding.ActivityDetailBinding

class ActivityDetail : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataBundle()
    }

    fun getDataBundle(){
        var bund = intent.extras

        var judul = bund!!.getString("judul")
        var jurnalis = bund!!.getString("jurnalis")
        var tanggal = bund!!.getString("tanggal")
        var detail = bund!!.getString("detail")

        binding.tvJudulDetail.text = judul
        binding.tvTanggalDetail.text = tanggal
        binding.tvJurnalisDetail.text = jurnalis
        binding.tvDetail.text = detail
    }
}