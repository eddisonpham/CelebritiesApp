package com.example.celebritiesapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BioActivity: AppCompatActivity() {

    private lateinit var bioActorImage: ImageView
    private lateinit var lblActorBio: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        bioActorImage = findViewById(R.id.bioActorImage)
        lblActorBio = findViewById(R.id.lblActorBio)

        var receivedData = intent.extras
        var actorName = receivedData!!.getString(ACTOR_NAME)
        var actorDes = receivedData!!.getString(ACTOR_DES)
        var actorImage = receivedData!!.getInt(ACTOR_IMAGE)

        bioActorImage.setImageResource(actorImage)
        lblActorBio.text = "$actorName - $actorDes"

    }

    companion object{
        val ACTOR_NAME = "name"
        val ACTOR_DES = "des"
        val ACTOR_IMAGE = "image"

    }
}