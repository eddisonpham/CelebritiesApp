package com.example.celebritiesapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class CelebrityListAdapter:BaseAdapter {

    private var celebrityDatabase: CelebrityDatabase? = null
    private var context: Context? = null

    constructor(context: Context) {
        celebrityDatabase = CelebrityDatabase()
        this.context = context
    }
    //returns the # of objects to show on ListView
    override fun getCount(): Int {
        return celebrityDatabase?.celebrityList?.size ?: 0
    }
    //returns the object according to index of object in ListView
    override fun getItem(p0: Int): Any {
        return celebrityDatabase?.celebrityList?.get(p0) ?:
        Celebrity("No Actor", "No Des", R.drawable.placeholder, false)
    }
    //returns the index of each object inside ListView
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    //gets called for each row inside ListView
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val celebrity: Celebrity = celebrityDatabase?.celebrityList?.get(p0)
            ?: Celebrity("No Actor", "No Des", R.drawable.placeholder, false)
        val celebrityView: View

        var layoutInflater:LayoutInflater = context?.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        celebrityView = if(celebrity.isAlive ?: false){
            layoutInflater.inflate(R.layout.alive_celebrity_row, null)
        }else{
            layoutInflater.inflate(R.layout.celebrity_row, null)
        }
        var actorImage: ImageView = celebrityView.findViewById(R.id.actorImage)
        var lblActorName : TextView = celebrityView.findViewById(R.id.lblActorName)
        var lblActorDes : TextView = celebrityView.findViewById(R.id.lblActorDes)

        actorImage.setImageResource(celebrity?.image ?: R.drawable.placeholder)
        lblActorName.setText(celebrity.name)
        lblActorDes.setText(celebrity.des)

        celebrityView.setOnClickListener {

            val actorBioIntent = Intent(context, BioActivity::class.java)
            actorBioIntent.putExtra(BioActivity.ACTOR_NAME,celebrity.name)
            actorBioIntent.putExtra(BioActivity.ACTOR_DES,celebrity.des)
            actorBioIntent.putExtra(BioActivity.ACTOR_IMAGE,celebrity.image)
            startActivity(context!!, actorBioIntent, null)
        }

        celebrityView.setOnLongClickListener {

            showDialog(p0)
            return@setOnLongClickListener true
        }

        return celebrityView
    }

    private fun showDialog(index: Int){

        val alertDialog: AlertDialog=
            AlertDialog.Builder(context).create()
        alertDialog.setTitle("Message")
        alertDialog.setMessage("What would you like to do?")

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Delete",{
            dialog: DialogInterface?, which: Int ->

            celebrityDatabase?.celebrityList?.removeAt(index)

            this@CelebrityListAdapter.notifyDataSetChanged()
        })

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Duplicate",{
                dialog: DialogInterface?, which: Int ->

            celebrityDatabase?.celebrityList?.add(index, celebrityDatabase?.celebrityList?.get(index)
                ?: Celebrity("No Actor", "No Des", R.drawable.placeholder, false))

            this@CelebrityListAdapter.notifyDataSetChanged()
        })
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Cancel", {
            dialog: DialogInterface?, which: Int ->

            alertDialog.dismiss()
        })
        alertDialog.setCancelable(true)

        alertDialog.show()
    }

}