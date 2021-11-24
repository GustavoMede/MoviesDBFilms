package com.example.moviesdbfilm.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdbfilm.data.repository.model.moviesdb.Movie
import com.example.moviesdbfilm.databinding.HomeItemLayoutBinding

typealias MovieListener = (Movie) -> Unit

class HomeFragmentAdapter(
    private val listener: MovieListener
): ListAdapter<Movie, HomeFragmentAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class HomeViewHolder(private val itemLayoutBind: HomeItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun bind(movie: Movie, listener: MovieListener){
            itemLayoutBind.movie = movie

            itemLayoutBind.root.setOnClickListener {
                listener.invoke(movie)
            }
        }

        companion object {
            fun create(parent: ViewGroup): HomeViewHolder{
                val itemBind = HomeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return HomeViewHolder(itemBind)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>(){

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.posterPath == newItem.posterPath
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.originalTitle == newItem.originalTitle
            }

        }
    }
}