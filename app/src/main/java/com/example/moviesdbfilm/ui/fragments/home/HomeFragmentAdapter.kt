package com.example.moviesdbfilm.ui.fragments.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesdbfilm.data.repository.model.Movie
import com.example.moviesdbfilm.databinding.HomeItemLayoutBinding

class HomeFragmentAdapter: ListAdapter<Movie, HomeFragmentAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        context = parent.context
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position), context)
    }

    class HomeViewHolder(private val itemLayoutBind: HomeItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun bind(movies: Movie, context: Context){

            itemLayoutBind.run {
                Glide.with(context).load(movies.poster_path).into(homeItemImage)
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
                return oldItem.poster_path == newItem.poster_path
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.original_title == newItem.original_title
            }

        }
    }
}