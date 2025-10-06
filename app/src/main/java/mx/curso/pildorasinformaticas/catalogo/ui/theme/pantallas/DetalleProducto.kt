package mx.curso.pildorasinformaticas.catalogo.ui.theme.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.curso.pildorasinformaticas.catalogo.data.ConfiguracionTema
import mx.curso.pildorasinformaticas.catalogo.data.RepositorioProductos


@Composable
fun pantallaDetalleProducto(navController: NavController, id: Int){

    val productoDetalle: RepositorioProductos = RepositorioProductos
    val producto = productoDetalle.getProducto(id)?:return
    // mutable para cambiar el color de fondo
    var cambiarColor by remember { mutableStateOf(ConfiguracionTema.getColor() ) }
    // mutable para poder mover la imagen
    var offset by remember { mutableStateOf (Offset.Zero ) }

    LazyColumn( modifier = Modifier.padding(10.dp, 30.dp).background(Color(cambiarColor)).fillMaxSize() ) {
        item {
            Button(
                onClick = {
                    // regresar a la pantalla anterior
                    navController.popBackStack()
                }
            ) {
                Text("Volver")
            }
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
//            if (producto != null){
            Box(modifier= Modifier
                .pointerInput(Unit){
                    // _ Posicion inicial del gesto de los dedos
                    // pan Desplazamiento
                    // zoom Zoom
                    detectTransformGestures { _, pan, zoom, rotationDelta ->
                        offset+=pan
                    }
                }
            ){
                Image(
                    painter = painterResource(producto.imagenId),
                    contentDescription = "${producto.descripcion}",
                    // re-ilustrar la imagen en su nueva posición
                    modifier=Modifier.graphicsLayer(translationY = offset.y, translationX = offset.x)
                )
            }
            Spacer(modifier=Modifier.height(10.dp))
            Text("${producto.nombre}")
            Text("${producto.descripcion}")
            Spacer(modifier=Modifier.height(30.dp))
            Button(
                onClick = {
                    cambiarColor =ConfiguracionTema.setColor()
                }
            ) {
                Text("Cambiar de color")
            }
//            }else{
//                Text("Producto no encontrado")
//            }
        }

    }
}