package com.aminivan.berita

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class AdapterNews(var listNews:ArrayList<ListNews>):
    RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private lateinit var context : Context
    private lateinit var detail: String

    class ViewHolder (view: View):RecyclerView.ViewHolder(view)  {
        var tvJudul = view.findViewById<TextView>(R.id.tvJudulBerita)
        var tvTanggal = view.findViewById<TextView>(R.id.tvTanggalBerita)
        var tvJurnalis = view.findViewById<TextView>(R.id.tvJurnalis)
        var ivGambar = view.findViewById<ImageView>(R.id.ivBerita)
        var cvItem = view.findViewById<CardView>(R.id.cv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvJudul.text = listNews[position].judul
        holder.tvJurnalis.text = listNews[position].jurnalis
        holder.tvTanggal.text = listNews[position].tanggal
        holder.ivGambar.setImageResource(listNews[position].gambar)
        detail = listNews[position].isiBerita

        holder.cvItem.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                var bundle = Bundle()
                bundle.putString("judul",holder.tvJudul.text.toString())
                bundle.putString("jurnalis",holder.tvJurnalis.text.toString())
                bundle.putString("tanggal",holder.tvTanggal.text.toString())
                bundle.putString("detail",detail)
                var intent = Intent(context,ActivityDetail::class.java)
                intent.putExtras(bundle)
                context.startActivity(intent)
            }
        })
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
    fun setDataNews(newsList : ArrayList<ListNews>){
        this.listNews = newsList
    }
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
}