package com.rodrigoribeiro.agenda.data

import androidx.lifecycle.MutableLiveData

class GestorDeNotas {

    private val data: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun getNotas() = data

    fun addNota(mNota: Nota) {
        var tmp = data.value
        if(tmp == null){
            tmp = mutableListOf()
            tmp.add(mNota)
        }else{
            tmp?.add(mNota)
        }

        data.postValue(tmp)
    }
}