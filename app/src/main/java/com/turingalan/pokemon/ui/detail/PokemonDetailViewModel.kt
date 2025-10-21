package com.turingalan.pokemon.ui.detail


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.turingalan.pokemon.data.model.Pokemon

import com.turingalan.pokemon.data.repository.PokemonRepository
import com.turingalan.pokemon.navigation.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class DetailUiSate(
    val name:String = "",
    val artworkId:Int? = null
)
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val pokemonRepository: PokemonRepository

): ViewModel() {

    private val _uiState: MutableStateFlow<DetailUiSate> =
        MutableStateFlow(DetailUiSate())
    val uiState: StateFlow<DetailUiSate>
    get() = _uiState.asStateFlow()
    init {
        val route = savedStateHandle.toRoute<Destination.Detail>()
        val pokemonId = route.id
        val pokemon = pokemonRepository.readOne(pokemonId)
        
        pokemon?.let {
            _uiState.value = pokemon.toDetailUiState()
        }

    }
}

fun Pokemon.toDetailUiState(): DetailUiSate = DetailUiSate(
    name = this.name,
    artworkId = this.artworkId
)