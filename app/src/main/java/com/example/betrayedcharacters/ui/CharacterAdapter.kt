package com.example.betrayedcharacters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.betrayedcharacters.data.Characters
import com.example.betrayedcharacters.databinding.CharactersItemLayoutBinding

class CharacterAdapter (val list : ArrayList<Characters>) : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {


    var onItemClick : ((Characters) -> Unit) ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): MyViewHolder {

        return MyViewHolder(
            CharactersItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val characters = list[position]
        holder.charactersBinding.imgView.setImageResource(list[position].image)
        holder.charactersBinding.txtView.text = list[position].name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(characters)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class MyViewHolder (val charactersBinding: CharactersItemLayoutBinding) :
        RecyclerView.ViewHolder(charactersBinding.root){

    }

}