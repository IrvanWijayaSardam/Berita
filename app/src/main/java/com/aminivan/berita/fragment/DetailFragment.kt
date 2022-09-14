package com.aminivan.berita.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aminivan.berita.R
import com.aminivan.berita.databinding.FragmentDetailBinding
import com.aminivan.berita.databinding.FragmentMainBinding


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()

    }

    fun getArgs(){
        var judul = arguments?.getString("judul")
        var jurnalis = arguments?.getString("jurnalis")
        var tanggal = arguments?.getString("tanggal")
        var detail = arguments?.getString("detail")
        binding.tvJudulDetailFragment.text = judul
        binding.tvTanggalDetailFragment.text = tanggal
        binding.tvJurnalisDetailFragment.text = jurnalis
        binding.tvDetailFragment.text = detail
    }
}