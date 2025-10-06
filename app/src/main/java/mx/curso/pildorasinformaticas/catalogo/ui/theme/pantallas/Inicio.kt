package mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun pantallaInicio(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido a Blatantbinkie")
        Spacer(modifier=Modifier.height(24.dp))
        Button(onClick = {
            navController.navigate("galeria")
        }){
            Text("Ver galeria")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            navController.navigate("acerca")
        }){
            Text("Sobre la App")
        }
        Spacer(modifier=Modifier.height(15.dp))
        Button(
            onClick = {
                navController.navigate("formulario")
            }
        ) {
            Text("Nuevo producto")
        }
    }
}