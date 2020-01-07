package com.example.sampleapplication.one


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleapplication.R
import com.example.sampleapplication.one.sub.OneOneFragment
import com.example.sampleapplication.two.sub.TwoOneFragment


class OneFragment : Fragment(),OneActivityCommunicator {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadFragment(OneOneFragment())
    }
    override fun loadFragment(fragment: Fragment) {
        val ft = childFragmentManager.beginTransaction()
        val fragmentTransaction = ft.add(R.id.frameOne, fragment)
        fragmentTransaction.addToBackStack(fragment.javaClass.name).commit()
    }

}
