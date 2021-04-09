package com.example.avengersapp

import androidx.lifecycle.ViewModel

class AvengersViewModel : ViewModel() {

    val listAvengers = mutableListOf<Avenger>()

    fun getAvengers() {
        listAvengers.addAll(mutableListOf(
        Avenger("Black Panther", R.mipmap.tres, R.mipmap.blackpanther, "Description", true),
        Avenger("Capitán América", R.mipmap.cuatro, R.mipmap.capitanamerica, "Description", true),
        Avenger("Dr. Strange", R.mipmap.cuatro, R.mipmap.drstrange, "Description", false),
        Avenger("Gamora", R.mipmap.tres, R.mipmap.gamora, "Description", true),
        Avenger("La viuda negra", R.mipmap.dos, R.mipmap.viudanegra, "Description", false),
        Avenger("Thanos", R.mipmap.cuatro, R.mipmap.thanos, "Description", false)
        ))
    }

    fun buenos(): List<Avenger>{
        return listAvengers.filter { it.esBueno }
    }

    fun malos(): List<Avenger>{
        return listAvengers.filter { !it.esBueno }
    }

}