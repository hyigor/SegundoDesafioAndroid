package br.com.digitalhouse.segundodesafiokotlin.UI

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.segundodesafiokotlin.Entities.Resposta
import br.com.digitalhouse.segundodesafiokotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview_item_comic.view.*

class RecyclerViewAdapter(private val listaComic: Resposta, private val lis: OnClick): RecyclerView.Adapter<RecyclerViewAdapter.RecylerViewHolder>() {

    override fun getItemCount(): Int =
        listaComic.data.results.size


    override fun onBindViewHolder(holder: RecyclerViewAdapter.RecylerViewHolder, position: Int) {
        val comicAct = listaComic.data.results[position]
        holder.name.text = "#${comicAct.issueNumber}"
        Picasso.get().load(Uri.parse("${comicAct.thumbnail.path}.${comicAct.thumbnail.extension}"))
            .into(holder.img)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.RecylerViewHolder {
        val comicView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_item_comic, parent, false)
        return RecylerViewHolder(comicView)

    }

    inner class RecylerViewHolder(objView: View) : RecyclerView.ViewHolder(objView), View.OnClickListener{
        val img: ImageView = objView.imagemComic
        val name: TextView = objView.idNumero
        init{
            objView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val pos = adapterPosition
            if(pos != RecyclerView.NO_POSITION){
                lis.onClick(pos)
            }
        }
    }

    interface OnClick{
        fun onClick(position: Int)
    }

//private fun View.OnClickListener.onClick(pos: Int) {
//
//}



}


