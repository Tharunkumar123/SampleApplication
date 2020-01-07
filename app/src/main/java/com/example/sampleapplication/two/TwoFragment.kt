package com.example.sampleapplication.two


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleapplication.R
import com.example.sampleapplication.one.TwoActivityCommunicator
import com.example.sampleapplication.one.sub.OneOneFragment
import com.example.sampleapplication.two.sub.TwoOneFragment


class TwoFragment : Fragment(),TwoActivityCommunicator {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadFragment(TwoOneFragment())
    }
    override fun loadFragment(fragment: Fragment) {
        val ft = childFragmentManager.beginTransaction()
        val fragmentTransaction = ft.add(R.id.frameTwo, fragment)
        fragmentTransaction.addToBackStack(fragment.javaClass.name).commit()
    }

}
