package com.example.primerparcialrecetas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta (
    val id:Int,
    val nombre:String,
    val dificultad:Dificultad,
    val pais:String,
    val imagen:String,
    val ingredientes:String
): Parcelable

enum class Dificultad {
    FACIL,
    NORMAL,
    DIFICIL
}