package com.example.avengersapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.avengersapp.databinding.ActivityDescriptionBinding
import com.example.avengersapp.databinding.ActivityMainBinding

class DescriptionActivity: AppCompatActivity() {

    lateinit var binding : ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val avenger = intent.getParcelableExtra<Avenger>("VALOR1")
        avenger?.let {
            binding.description.text = it.description
            binding.estrellas.setImageResource(it.estrellas)
            binding.imageView.setImageResource(it.foto)
            binding.superpoder.text = it.name
        }


    }
}