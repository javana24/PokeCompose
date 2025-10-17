package com.turingalan.pokemon.ui.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.turingalan.pokemon.data.model.Pokemon
import com.turingalan.pokemon.data.repository.PokemonInMemoryRepository
import com.turingalan.pokemon.ui.theme.components.PokemonItemDesign


@Composable
fun PokemonDetailScreenPreview(
    modifier: Modifier = Modifier,
    onNavigateToDetail: () -> Unit
){

        val pokemons: List<Pokemon> = PokemonInMemoryRepository.pokemonList()
        Scaffold(

        ){

                paddingValues ->
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentPadding = PaddingValues(8.dp)) {
                items(
                    items = pokemons,
                    key = {
                        it.id
                    }
                ){
                        pokemon ->
                    PokemonItemDesign(
                        pokemon = pokemon,
                        function = {
                            SelectedPokemon.pokemon = pokemon
                            onNavigateToDetail()
                        }

                    )
                }
            }
        }

    }
