package app.rebuy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rebuy.model.data.Memes
import app.rebuy.model.repository.MemesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MemesViewModel @Inject constructor(private val memesRepository: MemesRepository):ViewModel() {
private val _memes = MutableLiveData<Memes>()

val memes:LiveData<Memes>
    get() = _memes

     fun getMemesData(){
viewModelScope.launch {
    val memesData =memesRepository.fetchMemes()
    _memes.value = memesData
}


    }






}