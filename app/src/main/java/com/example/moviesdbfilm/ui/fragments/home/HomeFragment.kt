package com.example.moviesdbfilm.ui.fragments.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesdbfilm.data.repository.model.moviesdb.Movie
import com.example.moviesdbfilm.databinding.HomeFragmentLayoutBinding
import com.example.moviesdbfilm.support.AppLoading
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private var bind: HomeFragmentLayoutBinding? = null

    private val moviesViewModelViewModel: MoviesViewModel by viewModel()

    private lateinit var dialog: Dialog

    private val homeAdapter by lazy {
        HomeFragmentAdapter(oneMovieSelected)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        dialog = AppLoading().show(requireActivity())
        moviesViewModelViewModel.getMovies()
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private val oneMovieSelected = object : MovieListener {
        override fun invoke(movie: Movie) {
            val directions = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movie)
            findNavController().navigate(directions)
        }
    }

    private fun setRecyclerView(homeAdapter: HomeFragmentAdapter) {
        bind?.let {
            it.homeFragmentRecyclerView.run {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                adapter = homeAdapter
            }
        }
    }

    private fun setObservers() {
        moviesViewModelViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            it.data?.let { data ->
                homeAdapter.submitList(data.results)
                dialog.dismiss()
            }
            setRecyclerView(homeAdapter)
        })
    }

}