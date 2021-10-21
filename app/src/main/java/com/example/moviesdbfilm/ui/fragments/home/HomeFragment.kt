package com.example.moviesdbfilm.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesdbfilm.databinding.HomeFragmentLayoutBinding
import com.example.moviesdbfilm.domain.models.Movies
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private var bind: HomeFragmentLayoutBinding? = null

    private val moviesViewModel: Movies by viewModel()

    private val adapter = HomeFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = HomeFragmentLayoutBinding.inflate(layoutInflater, container, false)

        return bind!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setRecyclerView()
        moviesViewModel.getMovies()
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private fun setRecyclerView() {
        bind?.let {
            it.homeFragmentRecycleView.run {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                adapter = adapter
            }
        }
    }

    private fun setObservers() {
        moviesViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            it.data?.let { data ->
                adapter.submitList(data.results)
            }

        })
    }

}