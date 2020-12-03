package br.com.digitalhouse.segundodesafiokotlin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.digitalhouse.segundodesafiokotlin.R
import br.com.digitalhouse.segundodesafiokotlin.Service.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnClick {


    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerviewer_comics.layoutManager = GridLayoutManager(this,3)
//        recyclerviewer_comics.setHasFixedSize(true)
        viewModel.listaComicApi.observe(this){
            recyclerviewer_comics.swapAdapter(RecyclerViewAdapter(it,this),true)
        }
        viewModel.getComics()
    }

    override fun onClick(position: Int) {
        var clickComic = viewModel.listaComicApi.value?.data?.results?.get(position)
        var intent = Intent(this, DescricaoActivity::class.java)
        intent.putExtra("click", clickComic)
        startActivity(intent)

    }

}