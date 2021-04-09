package com.example.avengersapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Avenger(val name: String, val estrellas: Int, val foto: Int, val description: String, val esBueno: Boolean) : Parcelable