package com.aminivan.berita

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelNews: ViewModel() {
    val listBerita = arrayListOf(
        ListNews("Bom Bali","12/09/2022","Irvan Wijaya",R.drawable.ic_launcher_background,"Bom Bali meledak pada tgl sekian blablabala"),
        ListNews("Ferdi Sambo","12/09/2022","Nita Muktia",R.drawable.ic_launcher_background,"Bom Bali meledak pada tgl sekian blablabala")

    )

    val beritaList: MutableLiveData<List<ListNews>> = MutableLiveData()

    fun getNews(){
        var news = listBerita
        beritaList.value = news
    }

}