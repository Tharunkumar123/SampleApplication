package com.example.sampleapplication.two.sub


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.sampleapplication.R


class TwoThreeFragment : Fragment() {
    private lateinit var txtSubFragment: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two_three, container, false)
        txtSubFragment = view.findViewById(R.id.txtSubFragment)
        txtSubFragment.setOnClickListener {

        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        txtSubFragment.text ="2.3"
    }

}
