package carreiras.com.github.fundamentos_jetpack_compose_listas_lazy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carreiras.com.github.fundamentos_jetpack_compose_listas_lazy.components.GameCard
import carreiras.com.github.fundamentos_jetpack_compose_listas_lazy.components.StudioCard
import carreiras.com.github.fundamentos_jetpack_compose_listas_lazy.model.Game
import carreiras.com.github.fundamentos_jetpack_compose_listas_lazy.repository.getAllGames
import carreiras.com.github.fundamentos_jetpack_compose_listas_lazy.repository.getGamesByStudio
import carreiras.com.github.fundamentos_jetpack_compose_listas_lazy.ui.theme.FundamentosjetpackcomposelistaslazyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FundamentosjetpackcomposelistaslazyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaJogos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TelaJogos(modifier: Modifier = Modifier) {
    val todosJogos = remember { getAllGames() }
    var textoBusca by remember { mutableStateOf("") }
    var listaJogos by remember { mutableStateOf(todosJogos) }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Meus jogos favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        
        OutlinedTextField(
            value = textoBusca,
            onValueChange = { textoBusca = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nome do estúdio") },
            trailingIcon = {
                IconButton(onClick = {
                    listaJogos = getGamesByStudio(textoBusca)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar estúdio"
                    )
                }
            }
        )


        if (textoBusca.isNotEmpty() || listaJogos != todosJogos) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    textoBusca = ""
                    listaJogos = todosJogos
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Limpar filtro")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(todosJogos.distinctBy { it.studio }) { game ->
                StudioCard(game = game, onClick = {
                    textoBusca = game.studio
                    listaJogos = getGamesByStudio(game.studio)
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(listaJogos) { game ->
                GameCard(game = game)
            }
        }
    }
}

@Preview(showBackground = true, name = "Games Screen Preview")
@Composable
fun PreviewTelaJogos() {
    FundamentosjetpackcomposelistaslazyTheme {
        TelaJogos()
    }
}
