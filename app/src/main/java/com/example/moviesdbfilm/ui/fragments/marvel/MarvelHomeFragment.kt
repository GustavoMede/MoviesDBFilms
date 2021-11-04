package com.example.moviesdbfilm.ui.fragments.marvel

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesdbfilm.data.repository.model.marvel.Result
import com.example.moviesdbfilm.data.repository.model.moviesdb.Movie
import com.example.moviesdbfilm.databinding.MarvelHomeFragmentLayoutBinding
import com.example.moviesdbfilm.support.AppLoading
import com.example.moviesdbfilm.ui.fragments.home.HomeFragmentAdapter
import com.example.moviesdbfilm.ui.fragments.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarvelHomeFragment: Fragment() {

    private var bind: MarvelHomeFragmentLayoutBinding? = null

    private val marvelCharactersViewModel: MarvelCharactersViewModel by viewModel()

    private lateinit var dialog: Dialog

    private val homeAdapter by lazy {
        MarvelHomeFragmentAdapter(oneCharacterSelected)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return MarvelHomeFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        dialog = AppLoading().show(requireActivity())
        marvelCharactersViewModel.getChars()
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private val oneCharacterSelected = object : CharListener {
        override fun invoke(character: Result) {
            val directions = MarvelHomeFragmentDirections.actionMarvelHomeFragmentToCharacterDetailsFragment(character)
            findNavController().navigate(directions)
        }
    }

    private fun setObservers() {
        marvelCharactersViewModel.charsLiveData.observe(viewLifecycleOwner, Observer {
            it.data?.let { data ->
                homeAdapter.submitList(data)
                dialog.dismiss()
            }
            setRecyclerView(homeAdapter)
        })
    }

    private fun setRecyclerView(homeAdapter: MarvelHomeFragmentAdapter) {
        bind?.let {
            it.marvelHomeFragmentRecyclerview.run {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                adapter = homeAdapter
            }
        }
    }
}