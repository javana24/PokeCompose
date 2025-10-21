package com.turingalan.pokemon.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination(val route: String) {
    @Serializable
    object List: Destination(route = "PokemosScreen")

    @Serializable
    data class Detail(val id: Long): Destination(route="PokemonDetailViewModel")
}