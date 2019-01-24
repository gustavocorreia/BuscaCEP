package com.example.logonrmlocal.buscacep.ui.pesquisar

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.buscacep.model.Endereco
import com.example.logonrmlocal.buscacep.repository.EnderecoRepository

class PesquisaViewModel: ViewModel(){

    val enderecoRepository = EnderecoRepository()

    val endereco = MutableLiveData<Endereco>()
    var mensagemDeErro = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun buscar(cep: String){
        enderecoRepository.buscar(
                cep,
                onComplete = {
                    endereco.value = it
                    mensagemDeErro.value = ""
                    isLoading.value = false
                },
                onError = {
                    endereco.value = null
                    mensagemDeErro.value = it?.message
                    isLoading.value = false
                })
    }

}