package br.com.digitalhouse.segundodesafiokotlin.Entities

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Results(
    val id: Int,
    var title: String,
    val issueNumber: Int,
    val thumbnail: Thumbnail,
    var description: String,
    var pageCount: Int,
    var prices: ArrayList<Cost>,
    var modified: Date,
    var dates: ArrayList<ComicDate>
) : Serializable