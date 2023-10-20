package com.example.primerparcialrecetas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var tvnombreDetail: TextView
    private lateinit var ivImagen: ImageView
    private lateinit var tvIngredientes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getParcelableExtra<Receta>("receta")

        tvnombreDetail = findViewById(R.id.tv_nombre_detail)
        ivImagen = findViewById(R.id.iv_imagen_detail)
        tvIngredientes = findViewById(R.id.tv_ingredientes_detail)

        tvnombreDetail.text = receta?.nombre
        tvIngredientes.text = receta?.ingredientes

        Glide.with(this).load(receta?.imagen).into(ivImagen)
    }
}