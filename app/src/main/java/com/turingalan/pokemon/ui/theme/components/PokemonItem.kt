package com.turingalan.pokemon.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.turingalan.pokemon.data.model.Pokemon

@Composable
fun PokemonItemDesign(pokemon: Pokemon, function: () -> Unit){
    Row (modifier = Modifier.fillMaxWidth()
        .clickable{
            function()
        }.border(0.5.dp,Color.Black)
    ){
        Image(

            modifier = Modifier.size(80.dp).padding(horizontal = 8.dp).padding(vertical = 4.dp).clip(CircleShape),
            painter = painterResource(pokemon.artworkId),
            contentDescription = "Imagen del personaje",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Column {
            Text(pokemon.name, style = MaterialTheme.typography.titleLarge)
        }
    }
}