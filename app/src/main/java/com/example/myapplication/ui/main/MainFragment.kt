package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.fragment_main, container, false)

        var message = view.findViewById<TextView>(R.id.message)
        //message.text=viewModel.result.value.toString()

        viewModel.result.observe(viewLifecycleOwner, Observer {
            message.text = it.toString()
        })
        var num1 = view.findViewById<EditText>(R.id.editTextNumber)
        var num2 = view.findViewById<EditText>(R.id.editTextNumber)

/*        var num1=6.0
        var num2=2.0*/

        var add = view.findViewById<Button>(R.id.addButton)
        add.setOnClickListener {
            //viewModel.add(Math.random()*6,6.0)
            viewModel.add(num1.text.toString().toDouble(), num2.text.toString().toDouble())
        }

        var min = view.findViewById<Button>(R.id.minButton)
        min.setOnClickListener {
            viewModel.sub(num1.text.toString().toDouble(), num2.text.toString().toDouble())
        }

        var multi = view.findViewById<Button>(R.id.multiButton)
        multi.setOnClickListener {
            viewModel.multi(num1.text.toString().toDouble(), num2.text.toString().toDouble())
        }

        var division = view.findViewById<Button>(R.id.divisionButton)
        division.setOnClickListener {
            viewModel.division(num1.text.toString().toDouble(), num2.text.toString().toDouble())
        }

        return view
    }

}