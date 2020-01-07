package com.example.sampleapplication.two.sub


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.sampleapplication.R
import com.example.sampleapplication.one.TwoActivityCommunicator


class TwoOneFragment : Fragment() {
    private lateinit var txtSubFragment: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two_one, container, false)
        txtSubFragment = view.findViewById(R.id.txtSubFragment)
        txtSubFragment.setOnClickListener {
            if(this.parentFragment is TwoActivityCommunicator){
                (this.parentFragment as TwoActivityCommunicator).loadFragment(TwoTwoFragment())
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        txtSubFragment.text ="2.1"
    }

}
