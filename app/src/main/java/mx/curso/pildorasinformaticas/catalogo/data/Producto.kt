package mx.curso.pildorasinformaticas.catalogo.data

import android.net.Uri
import mx.curso.pildorasinformaticas.catalogo.R


data class Producto (val id:Int, val nombre:String, val imagenId: Int, val descripcion:String)

// objeto singleton
object RepositorioProductos {

    val listaProductos = mutableListOf<Producto>(
        Producto(1,"Bolso", R.drawable.bolso, "Bolso de Calvin Klein"),
        Producto(2,"Multiherramienta", R.drawable.multiherramienta, "Pinzas, desarmador y más"),
        Producto(3,"Proyector", R.drawable.proyector, "Proyector para poder ver tus videos favoritos"),
        Producto(4,"Soplador", R.drawable.soplador, "Pequeño soplador super potente"),
        Producto(5,"Volante de videojuegos", R.drawable.volante, "Volante para poder jugar videojuegos en Android y Pc Volante para poder jugar videojuegos en Android y Pc Volante para poder jugar videojuegos en Android y Pc Volante para poder jugar videojuegos en Android y Pc")
    )

    fun getProducto(id:Int): Producto? = listaProductos.find { it.id == id }

    fun newProducto(producto: Producto ){
        listaProductos.add(producto)
    }
    fun getNewId(): Int{
        val newId = listaProductos.size
        return newId + 1
    }

//    fun getProducto(id:Int): Producto?{
//        for ( it in listaProductos ) {
//            return it
//        }
//        return null
//    }
}
