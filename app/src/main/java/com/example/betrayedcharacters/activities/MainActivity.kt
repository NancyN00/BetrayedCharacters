package com.example.betrayedcharacters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betrayedcharacters.R
import com.example.betrayedcharacters.data.Characters
import com.example.betrayedcharacters.databinding.ActivityMainBinding
import com.example.betrayedcharacters.ui.CharacterAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CharacterAdapter
    private lateinit var list: ArrayList<Characters>
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setHasFixedSize is used to avoid unnecessary size layout calculations when item is removed or added

        binding.recyclerView.setHasFixedSize(true)

        list = ArrayList()
        list.add(Characters(R.drawable.aanemone, "Anemone"))
        list.add(Characters(R.drawable.beellona, "Beellona"))
        list.add(Characters(R.drawable.casper, "Casper"))
        list.add(Characters(R.drawable.ccaia, "Caia"))

        adapter = CharacterAdapter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.onItemClick ={
            val intent = Intent(this, DetailsActivity::class.java)
            //intent.putExtra("character", it)
            startActivity(intent)
        }
    }
}