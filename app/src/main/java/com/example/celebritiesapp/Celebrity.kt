package com.example.celebritiesapp

class Celebrity {
    var name: String? = null
    var des: String? = null
    var image: Int? = null
    var isAlive: Boolean? = null

    constructor (name: String, des: String, image: Int, isAlive: Boolean){
        this.name=name
        this.des=des
        this.image=image
        this.isAlive=isAlive
    }
}