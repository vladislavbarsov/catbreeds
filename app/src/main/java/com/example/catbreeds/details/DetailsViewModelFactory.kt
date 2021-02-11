package com.example.catbreeds.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catbreeds.network.BreedProperty

class DetailsViewModelFactory(
    private val breedProperty: BreedProperty,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(breedProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}