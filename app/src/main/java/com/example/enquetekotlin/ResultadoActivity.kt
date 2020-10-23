package com.example.enquetekotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ResultadoActivity : AppCompatActivity() {
    lateinit var textDino: TextView
    lateinit var textPlana: TextView
    lateinit var textGlobo: TextView
    lateinit var textModelo: TextView
    lateinit var textDescricao: TextView
    lateinit var imgResultado: ImageView
    private val gerador = Random()
    private var resDino = 0
    private var resPlana = 0
    private var resGlobo = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val i = intent
        val terra = i.getSerializableExtra("a") as Terra?
        textDino = findViewById(R.id.textTerraDino)
        textPlana = findViewById(R.id.textTerraPlana)
        textGlobo = findViewById(R.id.textTerraGlobo)
        textModelo = findViewById(R.id.textVotos)
        textDescricao = findViewById(R.id.textDescricao)
        imgResultado = findViewById(R.id.imgResultado)
        resDino = gerador.nextInt(100) + 1
        resPlana = gerador.nextInt(100 - resDino) + 1
        resGlobo = 100 - (resDino + resPlana)
        textDino.setText("Terra Dinossauro: $resDino%")
        textPlana.setText("Terra Plana: $resPlana%")
        textGlobo.setText("Terra Globo: $resGlobo%")
        textModelo.setText("Seu voto: " + terra!!.nome)
        textDescricao.setText(terra.descricao)
        imgResultado.setImageResource(terra.caminho)
    }
}