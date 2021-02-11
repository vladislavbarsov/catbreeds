package com.example.catbreeds.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.catbreeds.network.BreedProperty

class DetailsViewModel(breedProperty: BreedProperty, app: Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<BreedProperty>()
    val selectedProperty: LiveData<BreedProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = breedProperty
    }

}