package com.rodrigoribeiro.agenda.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodrigoribeiro.agenda.data.GestorDeNotas
import com.rodrigoribeiro.agenda.data.Nota

class NotasViewModel: ViewModel() {

    private val gestorNotas = GestorDeNotas()
    private val mNotas = MutableLiveData<List<Nota>>()

    fun getNotas(): MutableLiveData<List<Nota>> = mNotas

    fun carregarNotas(){
        val tmp = gestorNotas.getNotas()
        mNotas.postValue(tmp)
    }

}