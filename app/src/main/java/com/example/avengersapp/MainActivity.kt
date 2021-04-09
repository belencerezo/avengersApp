package com.example.avengersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avengersapp.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = ViewModelProvider(this).get(AvengersViewModel::class.java)
        model.getAvengers()

        var adapter = AvengersAdapter(model.buenos())

        createRecycler(adapter)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { itemSelected ->
            when (itemSelected.itemId) {
                R.id.avengers -> {
                    adapter.updateAvengers(model.buenos())
                }
                R.id.villians -> {
                    adapter.updateAvengers(model.malos())
                }
                R.id.battle -> {
                    Toast.makeText(this, "Coming soon", Toast.LENGTH_LONG ).show()
                }
            }
            true
        }

    }

    private fun createRecycler(adapter: AvengersAdapter){
        binding.reclycerview.layoutManager = LinearLayoutManager(this)
        binding.reclycerview.adapter = adapter
    }

}