package mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.curso.pildorasinformaticas.catalogo.R
import mx.curso.pildorasinformaticas.catalogo.data.Producto
import mx.curso.pildorasinformaticas.catalogo.data.RepositorioProductos

@Composable
fun pantallaFormulario(navController: NavController){

    var tituloProducto by remember { mutableStateOf("") } //Estado para el texto
    var descripcionProducto by remember { mutableStateOf("") } //Estado para el texto
//    var imagenProducto = R.drawable.bolso
    var imagenProducto by remember { mutableStateOf<Uri?>(null) }


    Column (modifier = Modifier
        .padding(5.dp, 30.dp)
    ) {
        OutlinedTextField(
            value = tituloProducto,
            // cada que se escribe un caracter se va almacenando en la variable tituloProducto
            onValueChange = { tituloProducto = it },
            label = { Text("Titulo del producto") },
            placeholder = {Text("Ingresa un titulo del producto")},
            isError = tituloProducto.isBlank()
        )
        Spacer(modifier=Modifier.height(15.dp))
        OutlinedTextField(
            value = descripcionProducto,
            onValueChange = { textoIngresadoDetallo ->
                descripcionProducto = textoIngresadoDetallo
            },
            label = { Text( "Ingresa una descripción") },
            isError = descripcionProducto.length < 10
        )
        Spacer(modifier=Modifier.height(15.dp))
        // iniciarla actividad y esperar el resultado en este caso la imagen
        // Launcher para seleccionar una imagen de la galeria
        val pickImageLauncher = rememberLauncherForActivityResult(
            // contract = que tipo de actividad vamos a lanzar
            // ActivityResultContracts.PickVisualMedia = abrir el selector de contenido
//            contract = ActivityResultContracts.PickVisualMedia()
            contract = ActivityResultContracts.GetContent()
            // Uri? = se pone ? por si el usuario cancela la seleccion de imagen, daria nulo
        ) { uri: Uri? ->
            imagenProducto = uri
        }

        // Permisos para acceder a la galaria
//        val permissionLauncher = rememberLauncherForActivityResult(
//            contract = ActivityResultContracts.RequestPermission()
//        ){
//            isGranted ->
//                if ( isGranted ) {
//                    pickImageLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
//                }
//        }
        Button(
            // launch = funcion de lanzar
            // image/* = para seleccionar que tipo de imagen podemos seleccionar "jpg,npg,etc"
            onClick = { pickImageLauncher.launch("image/*") }
        ) {
            Text("Seleccionar imagen")
        }
        Spacer(modifier=Modifier.height(15.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    navController.navigate("inicio")
                }
            ){
                Text("Volver")
            }
            Button(
                onClick = {
                    val newId = RepositorioProductos.getNewId()
                    if ( tituloProducto != "" && descripcionProducto.isNotBlank() && descripcionProducto.length >= 10){
                        RepositorioProductos.newProducto(Producto(newId,tituloProducto,imagenProducto,descripcionProducto))
                        navController.navigate("galeria")
                    }
                },
                enabled = tituloProducto.isNotBlank() && descripcionProducto.isNotBlank() && descripcionProducto.length >= 10

            ) {
                Text("Registrar")
            }
        }
    }

}