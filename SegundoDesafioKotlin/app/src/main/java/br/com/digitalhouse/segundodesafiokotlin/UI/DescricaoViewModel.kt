package br.com.digitalhouse.segundodesafiokotlin.UI

import android.app.AppOpsManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import br.com.digitalhouse.segundodesafiokotlin.Entities.Results
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
class DescricaoViewModel(com: Results): ViewModel() {

    var cost = com?.prices?.get(0)?.price
    var title = com?.title
    var pages = com?.pageCount
    var publishe = com?.dates?.get(0)?.date
    var description = com?.description
    var background = "${com?.thumbnail?.path}.${com?.thumbnail?.extension}"

fun proc() {


    if (description == null) {
        val text = "Essa comic não apresenta descrição."
        description = text
    }


}
}


