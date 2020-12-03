package br.com.digitalhouse.segundodesafiokotlin.UI

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.digitalhouse.segundodesafiokotlin.Entities.Results
import br.com.digitalhouse.segundodesafiokotlin.R
import br.com.digitalhouse.segundodesafiokotlin.Service.service
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_descricao.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

open class DescricaoActivity : AppCompatActivity() {

    val viewModel by viewModels<DescricaoViewModel> {
        var com = intent.getSerializableExtra("click") as Results
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DescricaoViewModel(com) as T
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descricao)

        imgComic.setOnClickListener{
            card_visibilidade.visibility = VISIBLE
            cardComic.visibility = INVISIBLE
        }

        imageVoltar.setOnClickListener{
            card_visibilidade.visibility = INVISIBLE
            cardComic.visibility = VISIBLE


        }

        imageRetornar.setOnClickListener{
            finish()
        }

        viewModel.proc()

        Picasso.get().load(Uri.parse(viewModel.background)).into(imgComic)
        Picasso.get().load(Uri.parse(viewModel.background)).into(bannerComic)
        Picasso.get().load(Uri.parse(viewModel.background)).into(posterBig)

        text_titulo.text = viewModel.title
        text_descricao.text = viewModel.description
        text_preco.text = "$ ${viewModel.cost}"
        text_pgs.text = viewModel.pages.toString()


        var dat = SimpleDateFormat("MMM dd, yyyy")
        text_lanc.text = dat.format(viewModel.publishe)

//        var com = intent.getSerializableExtra("click") as Results
//        var cost = com?.prices?.get(0)?.price
//        var title = com?.title
//        var pages = com?.pageCount
//        var publishe = com?.dates?.get(0)?.date
//        var description = com?.description
//        var background = "${com?.thumbnail?.path}.${com?.thumbnail?.extension}"
//        Picasso.get().load(Uri.parse(background)).into(imgComic)
//        Picasso.get().load(Uri.parse(background)).into(bannerComic)
//        Picasso.get().load(Uri.parse(background)).into(posterBig)
//        if(description == null){
//            val text = "Essa comic não apresenta descrição."
//            description = text
//        }
//
//        text_titulo.text = title
//        text_descricao.text = description
//        text_preco.text = "$ ${cost}"
//        text_pgs.text = pages.toString()
//
//
//        var dat = SimpleDateFormat("MMM dd, yyyy")
//        text_lanc.text = dat.format(publishe)


    }







}