package com.example.catbreeds.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.photosGrid.adapter = ItemGridAdapter(ItemGridAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailsFragment(it)
                )
                viewModel.displayPropertyDetailsComplete()
            }
        })

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.list_fragment_name)

        return binding.root
    }


}