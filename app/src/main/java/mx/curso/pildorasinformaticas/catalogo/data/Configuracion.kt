package mx.curso.pildorasinformaticas.catalogo.data

import androidx.compose.ui.graphics.Color

data class Tema( var colorTema: Color )

object ConfiguracionTema {

    var tColor: Long = 0xFF476810

    fun getColor(): Long{
        return tColor
    }

    fun setColor(): Long{
        tColor = (0xFF000000 .. 0xFFFFFFFF).random()
        return tColor
    }
//    fun setColor(color: Color): Color{
//        tColor = color
//        return tColor
//    }

}
