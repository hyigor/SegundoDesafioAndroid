package br.com.digitalhouse.segundodesafiokotlin.Entities

import java.io.Serializable
import java.util.*

data class ComicDate (
        var type: String,
        var date: Date
): Serializable