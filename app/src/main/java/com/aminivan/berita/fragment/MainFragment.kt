package com.aminivan.berita.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aminivan.berita.AdapterNews
import com.aminivan.berita.ListNews
import com.aminivan.berita.R
import com.aminivan.berita.ViewModelNews
import com.aminivan.berita.databinding.FragmentDetailBinding
import com.aminivan.berita.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    lateinit var adapterNews: AdapterNews
    lateinit var vmNews: ViewModelNews
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycle()


        vmNews = ViewModelProvider(this).get(ViewModelNews::class.java)
        vmNews.getNews()
        vmNews.beritaList.observe(requireActivity(), Observer {
            adapterNews.setDataNews(it as ArrayList<ListNews>)
        })
    }

    fun setRecycle(){
        adapterNews = AdapterNews(ArrayList())

        binding.rvNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvNews.adapter = adapterNews
    }



}