package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        var add = view.findViewById<Button>(R.id.addButton)
        add.setOnClickListener {
            viewModel.add(Math.random()*6,6.0)
        }
        return view
    }

}