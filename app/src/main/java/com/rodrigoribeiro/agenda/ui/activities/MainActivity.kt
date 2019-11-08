package com.rodrigoribeiro.agenda.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.rodrigoribeiro.agenda.R
import com.rodrigoribeiro.agenda.data.Nota
import com.rodrigoribeiro.agenda.ui.NotasAdapter
import com.rodrigoribeiro.agenda.viewmodels.NotasViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialogo_ui.view.*

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var notasViewModel: NotasViewModel

    val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        recycler_view.adapter = notasAdapter
        recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        //inicializar o ViewModel
        notasViewModel = ViewModelProviders.of(this).get(NotasViewModel::class.java)

        notasViewModel.getNotas().observe(this, Observer{ data ->
            data?.let{
                if (it.isEmpty()){
                    Toast.makeText(this, "Lista vazia!", Toast.LENGTH_LONG).show()
                }else{
                    notasAdapter.add(it)
                }

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_principal,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item!!.itemId == R.id.action_adicionar){
            dialogoAddNota()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun dialogoAddNota(){
        val layout = LayoutInflater.from(this).inflate(R.layout.dialogo_ui,null, false)

        val inputNota = layout.input_nota

        val dialog = AlertDialog.Builder(this).apply {
            setView(layout)
            setNegativeButton("Cancelar",null)
            setPositiveButton("Salvar") { d, i ->
                // Salvar a nota
                val nota = Nota(id = 0, text = inputNota.text.toString())
                notasViewModel.salvar(nota)

            }

            create().show()
        }
    }
}
