package br.com.digitalhouse.segundodesafiokotlin.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.segundodesafiokotlin.Entities.Resposta
import br.com.digitalhouse.segundodesafiokotlin.Service.Repository
import br.com.digitalhouse.segundodesafiokotlin.Service.service
import kotlinx.coroutines.launch

class MainViewModel(service: Repository): ViewModel() {

    var listaComicApi = MutableLiveData<Resposta>()

    fun getComics(){
        viewModelScope.launch {
            listaComicApi.value = service.getResults(90,"1","6eb7e8896ec5850c52515a8a23ee97f0","40a3aa568bb269dfad85ae0c4a297181","spider-man",true)

        }
    }


}