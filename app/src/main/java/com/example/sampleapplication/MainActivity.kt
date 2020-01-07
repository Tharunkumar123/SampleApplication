package com.example.sampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.sampleapplication.one.OneFragment
import com.example.sampleapplication.two.TwoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        loadFragment(OneFragment())
    }

    private fun initViews() {
        bottomNavigationView.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.bottomNavigationOne -> {
                        loadFragment(OneFragment())
                        return true
                    }
                    R.id.bottomNavigationTwo -> {
                        loadFragment(TwoFragment())
                        return true
                    }
                    else -> {

                        return false
                    }
                }
            }

        })
    }

    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        val backStackFragment = supportFragmentManager.findFragmentByTag(fragment.javaClass.name)
        if (backStackFragment != null) {
            for (fragment in supportFragmentManager.fragments) {
                if (fragment::class.java.simpleName != backStackFragment::class.java.simpleName) {
                    ft.hide(fragment)
                }
            }
            ft.show(backStackFragment).commit()
        } else {
            val fragmentTransaction = ft.add(R.id.container, fragment, fragment.javaClass.name)
            fragmentTransaction.addToBackStack(fragment.javaClass.name).commit()
        }

    }

    override fun onBackPressed() {
        var currentFragment: Fragment? = null
        val backStackList = supportFragmentManager.fragments
        if (backStackList.size > 0) {
            currentFragment = backStackList[backStackList.size - 1]
        }
        if (currentFragment?.childFragmentManager?.backStackEntryCount ?: 0 > 1) {
            currentFragment?.childFragmentManager?.popBackStack()
        } else if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

}
