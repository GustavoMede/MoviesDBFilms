package com.example.moviesdbfilm.ui.fragments.moviesdbdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.moviesdbfilm.databinding.MovieDetailsFragmentLayoutBinding

class MovieDetailsFragment: Fragment() {

    private val movie by navArgs<MovieDetailsFragmentArgs>()

    private var bind: MovieDetailsFragmentLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return MovieDetailsFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewBind()
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private fun onViewBind() {
        bind?.let {
            it.movie = movie.movie
        }
    }
}