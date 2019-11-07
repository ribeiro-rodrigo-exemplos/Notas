package com.rodrigoribeiro.agenda.data

class GestorDeNotas {

    private val data = listOf<Nota>(
        Nota(id=0, text = "Nota 1"),
        Nota(id=1, text = "Nota 2"),
        Nota(id=2, text = "Nota 3"),
        Nota(id=3, text = "Nota 4"),
        Nota(id=4, text = "Nota 5")
    )

    fun getNotas() = data
}