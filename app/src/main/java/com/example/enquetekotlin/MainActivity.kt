package com.example.enquetekotlin


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    private var enviar: Button? = null
    lateinit var radioGroup: RadioGroup
    private var imgTerraDino: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enviar = findViewById(R.id.btEnviar)
        radioGroup = findViewById(R.id.radioGroup)
        imgTerraDino = findViewById(R.id.imageTerraDino)

    }

    fun Enviar (v : View){
        val intent = Intent(applicationContext, ResultadoActivity::class.java)
        val terra = Terra()
        val selectedId = radioGroup.getCheckedRadioButtonId()
        when (selectedId) {
            R.id.radioDino -> {
                //enviar.setText("Dino");
                terra.caminho = R.drawable.terra_dinossauro
                terra.nome = "Terra Dinossauro"
                terra.descricao =
                    "A teoria da terra dinossauro apareceu em meados de 2015 como um meme, no auge das discuções sobre terra plana"
            }
            R.id.radioPlana -> {
                //enviar.setText("Plana");
                terra.caminho = R.drawable.terra_plana
                terra.nome = "Terra Plana"
                terra.descricao =
                    "A teoria da terra plana retornou a pauta em meados de 2015, em 2020 ganhou um novo gas com o surgimento do fenomeno SUPER XANDAO"
            }
            R.id.radioGlobo -> {
                // enviar.setText("Globo");
                terra.caminho = R.drawable.terra_globo2
                terra.nome = "Terra Globo"
                terra.descricao =
                    "A teoria da terra globo é hoje a mais aceita entre os cietistas e pessoas em geral, mesmo o ultimo grupo nao sabendo explica-la"
            }
            else -> {
                val toast = Toast.makeText(
                    applicationContext,
                    "Selecione uma opção!",
                    Toast.LENGTH_LONG
                )
                toast.show()
            }
        }
        if (terra.nome != null) {
            intent.putExtra("a", terra as Serializable)
            startActivity(intent)
        }
    }
}