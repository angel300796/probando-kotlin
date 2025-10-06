package mx.curso.pildorasinformaticas.catalogo

import android.os.Bundle 
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas.pantallaAcerca
import mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas.pantallaDetalleProducto
import mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas.pantallaFormulario
import mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas.pantallaGaleria
import mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas.pantallaInicio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductosApp()
        }
    }
}

@Composable
fun ProductosApp(){

    val navegacion = rememberNavController()
    NavHost(navController = navegacion, startDestination = "inicio"){
        composable("inicio") { pantallaInicio (navegacion) }
        composable("acerca") { pantallaAcerca (navegacion) }
        composable("galeria") { pantallaGaleria( navegacion ) }
        composable("formulario") { pantallaFormulario( navegacion ) }
        composable(
            "descripcion/{id}",
            arguments = listOf(navArgument("id"){ type = NavType.IntType })
        ) {
            backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")?:0
            pantallaDetalleProducto( navegacion,id )
        }
    }
}