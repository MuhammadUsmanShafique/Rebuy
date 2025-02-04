package app.rebuy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.rebuy.R
import app.rebuy.model.data.DataItem
import app.rebuy.model.data.New_Arrivals_Item_Model
import app.rebuy.model.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository:HomeRepository,) :ViewModel() {

    private val _allSectionsData = MutableLiveData<List<DataItem>>()
    val getAllSectionsData : LiveData<List<DataItem>>
        get() = _allSectionsData

    fun loadData() {

   val sectionList = homeRepository.getAllSectionsData()
        _allSectionsData.value = sectionList
    }




}