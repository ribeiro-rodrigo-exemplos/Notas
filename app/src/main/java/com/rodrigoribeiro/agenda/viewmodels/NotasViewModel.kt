package com.rodrigoribeiro.agenda.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodrigoribeiro.agenda.data.GestorDeNotas
import com.rodrigoribeiro.agenda.data.Nota

class NotasViewModel: ViewModel() {

    private val gestorNotas = GestorDeNotas()
    private var mNotas: MutableLiveData<MutableList<Nota>>? = null

    fun getNotas(): LiveData<MutableList<Nota>> {
        if(mNotas == null){
            mNotas = gestorNotas.getNotas()

        }

        return mNotas!!
    }

    fun salvar(mNota: Nota){
        gestorNotas.addNota(mNota)
    }

    /*fun carregarNotas(){
        val tmp = gestorNotas.getNotas()
        mNotas?.postValue()
    }*/

}