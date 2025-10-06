package mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun pantallaAcerca( navController: NavController ){

    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Button(onClick = {
            navController.popBackStack()
        }){
            Text("Volver")
        }
        Spacer(modifier=Modifier.height(10.dp))
        Text("Blatantbinkie", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier=Modifier.height(10.dp))
        Text("Cátalogo de productos en venta de la tienda Blatantbinkie")
    }

}