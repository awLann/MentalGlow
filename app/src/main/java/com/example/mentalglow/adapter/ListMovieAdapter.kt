package com.example.mentalglow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mentalglow.data.response.MovieResponseItem
import com.example.mentalglow.databinding.ItemRowMovieBinding

class ListMovieAdapter(private val listMovie: List<MovieResponseItem>):
    RecyclerView.Adapter<ListMovieAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemRowMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movieData: MovieResponseItem) {
            binding.tvMovieTitle.text = movieData.title
            binding.tvMovieGenre.text = movieData.genre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
}