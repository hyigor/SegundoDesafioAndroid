package br.com.digitalhouse.segundodesafiokotlin.Entities

import java.io.Serializable

data class Cost(
        var type: String,
        var price: Float
): Serializable