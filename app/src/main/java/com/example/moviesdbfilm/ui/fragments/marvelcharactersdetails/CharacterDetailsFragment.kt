package com.example.moviesdbfilm.ui.fragments.marvelcharactersdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.moviesdbfilm.databinding.CharacterDetailsFragmentLayoutBinding

class CharacterDetailsFragment: Fragment() {

    private val character by navArgs<CharacterDetailsFragmentArgs>()

    private var bind: CharacterDetailsFragmentLayoutBinding? = null

    //Perguntar se tem como transformar um fragment em singleTop.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return CharacterDetailsFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewBind()
    }

    private fun onViewBind() {
        bind?.let {
            it.character = character.character
        }
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }
}