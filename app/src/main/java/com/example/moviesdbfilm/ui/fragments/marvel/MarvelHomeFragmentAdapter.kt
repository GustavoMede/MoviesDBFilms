package com.example.moviesdbfilm.ui.fragments.marvel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdbfilm.data.repository.model.marvel.Result
import com.example.moviesdbfilm.databinding.MarvelHomeItemLayoutBinding

typealias CharListener = (Result) -> Unit

class MarvelHomeFragmentAdapter(
    private val listener: CharListener
): ListAdapter<Result, MarvelHomeFragmentAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class HomeViewHolder(private val itemLayoutBind: MarvelHomeItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun bind(character: Result, listener: CharListener){
            itemLayoutBind.character = character

            itemLayoutBind.root.setOnClickListener {
                listener.invoke(character)
            }
        }

        companion object {
            fun create(parent: ViewGroup): HomeViewHolder{
                val itemBind = MarvelHomeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return HomeViewHolder(itemBind)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Result>(){

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.description == newItem.description
            }

        }
    }
}