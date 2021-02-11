package com.example.catbreeds.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val breedProperty = DetailsFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailsViewModelFactory(breedProperty, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_fragment_name)

        return binding.root
    }

}