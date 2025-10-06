package mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.curso.pildorasinformaticas.catalogo.data.RepositorioProductos

@Composable
fun pantallaGaleria(navController: NavController){

    val productos = RepositorioProductos

    LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp, 30.dp)
    ){
        item {
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Volver")
            }
        }
        for ( it in productos.listaProductos ){
            item {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation( defaultElevation = 6.dp ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                        .clickable(onClick = {
                            navController.navigate("descripcion/${it.id}")
                        })
                ) {
                    Row {
                        Image(painter = painterResource( it.imagenId ), contentDescription="", modifier= Modifier
                            .size(105.dp)
                            .padding(10.dp)
                        )
                        Column(modifier=Modifier.padding(5.dp,15.dp)) {
                            Text("${it.nombre}", style= MaterialTheme.typography.titleLarge)
                            Spacer(modifier=Modifier.height(7.dp))
                            Text(it.descripcion, maxLines = 2)
                        }
                    }
                }
            }
        }
    }
}
