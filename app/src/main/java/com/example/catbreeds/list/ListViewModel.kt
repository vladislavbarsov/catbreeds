package com.example.catbreeds.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catbreeds.network.BreedApi
import com.example.catbreeds.network.BreedProperty
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<List<BreedProperty>>()
    val properties: LiveData<List<BreedProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<BreedProperty>()
    val navigateToSelectedProperty : LiveData<BreedProperty>
        get() = _navigateToSelectedProperty

    init {
        getBreedList()
    }

    private fun getBreedList(){
        viewModelScope.launch {
            try {
                _properties.value = BreedApi.retrofitService.getProperties()
                _response.value = "Success: Breeds retrieved"

            } catch (e: Exception) {
                _response.value = "Failed: ${e.message}"
            }
        }

    }

    fun displayPropertyDetails(breedProperty: BreedProperty) {
        _navigateToSelectedProperty.value = breedProperty
    }
    fun displayPropertyDetailsComplete(){
        _navigateToSelectedProperty.value = null
    }

}