package com.fatihbaser.navigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {// butun goruntuler cagirildiktan sonra aaciliyor

        super.onViewCreated(view, savedInstanceState)
        button1.setOnClickListener{
            val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment("BASER")
            Navigation.findNavController(it).navigate(action)
        }

    }



}