package com.example.primerparcialrecetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {

    private lateinit var rvRecetas: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRecetas = findViewById(R.id.rv_recetas)
        rvRecetas.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvRecetas.adapter = adapter
        adapter.submitList(getListadoEquipos())

        adapter.onItemClickListener = {
            navegarDetalle(it)
        }
    }

    private fun navegarDetalle(receta: Receta) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }

    private fun getListadoEquipos(): MutableList<Receta>? {
        return mutableListOf(
            Receta(1,
                "Paella Española",
                Dificultad.NORMAL,
                "España",
                "https://static.onecms.io/wp-content/uploads/sites/21/2017/04/24/paella-espac3b1ola-2000.jpg",
                "Arroz, pollo, conejo, judías verdes, pimientos, azafrán, caldo de pollo, aceite de oliva, tomate, cebolla, ajo."
            ),
            Receta(2,
                "Spaghetti Carbonara",
                Dificultad.FACIL,
                "Italia",
                "https://img2.rtve.es/imagenes/autentica-receta-pasta-carbonara/1667822498726.jpg",
                " Espaguetis, panceta, huevos, queso parmesano, pimienta negra."
            ),
            Receta(3,
                "Goulash",
                Dificultad.NORMAL,
                "Hungría",
                "https://alicante.com.ar/uploads/recetas/2718_receta.jpg",
                "Carne de res, cebolla, pimiento rojo, paprika, tomate, patatas, aceite, caldo de res."
            ),
            Receta(4,
                "Coq au Vin",
                Dificultad.DIFICIL,
                "Francia",
                "https://www.agaliving.com/sites/default/files/2019-01/Coq%20Au%20Vin%20Normal.jpg",
                "Pollo, vino tinto, champiñones, cebolla, panceta, caldo de pollo, zanahorias, ajo."
            ),
            Receta(5,
                "Moussaka",
                Dificultad.DIFICIL,
                "Grecia",
                "https://www.mygreekdish.com/wp-content/uploads/2013/05/Moussaka-recipe-Traditional-Greek-Moussaka-with-Eggplants.jpg",
                "Berenjenas, carne de cordero, tomate, cebolla, bechamel, queso feta, aceite de oliva."
            ),
            Receta(6,
                "Shepherd's Pie",
                Dificultad.FACIL,
                "Reino Unido",
                "https://www.perfectitaliano.com.au/content/dam/perfectitaliano-aus/recipe/easy-family-shepherds-pie_standard.jpg",
                "Carne de cordero, guisantes, zanahorias, cebolla, puré de papas, mantequilla."
            ),
            Receta(7,
                "Borscht",
                Dificultad.NORMAL,
                "Ucrania",
                "https://images.squarespace-cdn.com/content/v1/52e887bee4b06b90fc8a7e3d/7f54b15d-3fa2-4e3d-99c1-3d267c248e77/Borscht.jpg",
                "Remolacha, carne de res, col, cebolla, zanahorias, ajo, caldo de res."
            ),
            Receta(8,
                "Risotto de Champiñones",
                Dificultad.NORMAL,
                "Italia",
                "https://locosxlaparrilla.com/wp-content/uploads/2015/02/Receta-recetas-locos-x-la-parrilla-locosxlaparrilla-receta-risotto-champi%C3%B1ones-queso-risotto-champi%C3%B1ones-queso-receta-risotto-risotto-2.jpg",
                "Arroz Arborio, champiñones, cebolla, vino blanco, caldo de pollo, mantequilla, queso parmesano."
            )
        )
    }
}