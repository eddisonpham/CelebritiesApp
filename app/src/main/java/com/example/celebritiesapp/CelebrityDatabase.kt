package com.example.celebritiesapp

class CelebrityDatabase {
    var celebrityList: ArrayList<Celebrity>? = null
    constructor(){
        celebrityList= ArrayList()
        celebrityList?.add(Celebrity(
            "Angelina Jolie",
            "Angelina Jolie is an American actress",
            R.drawable.angelina_jolie,
            true
        ))
        celebrityList?.add(Celebrity(
            "Audrey Hepburn",
            "Audrey Hepburn was a British actor",
            R.drawable.audrey_hepburn,
            false
        ))
        celebrityList?.add(Celebrity(
            "Brad Pitt",
            "Brad Pitt is an American actor",
            R.drawable.brad_pitt,
            true
        ))
        celebrityList?.add(Celebrity(
            "Elizabeth Taylor",
            "Elizabeth Taylor was a British-American actress",
            R.drawable.elizabeth_taylor,
            false
        ))
        celebrityList?.add(Celebrity(
            "Ingrid Bergman",
            "Ingrid Bergman was a Swedish actor",
            R.drawable.ingrid_bergman,
            false
        ))
        celebrityList?.add(Celebrity(
            "James Stewart",
            "James Stewart was an American actor",
            R.drawable.james_stewart,
            false
        ))
        celebrityList?.add(Celebrity(
            "Marilyn Monroe",
            "Marilyn Monroe was an American actress",
            R.drawable.marilyn_monroe,
            false
        ))
    }
}