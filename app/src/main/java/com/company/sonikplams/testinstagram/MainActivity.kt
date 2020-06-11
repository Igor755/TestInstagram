package com.company.sonikplams.testinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.company.sonikplams.testinstagram.fragments_bottom_navigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var onFragmentBackPressed: (() -> Unit)? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.setOnNavigationItemReselectedListener {}

        val homeFragment = HomeFragment()
        openFragment(homeFragment)

    }



    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val homeFragment = HomeFragment()
                    openFragment(homeFragment)
                    showToast("R.id.home")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    val searchFragment = SearchFragment()
                        openFragment(searchFragment)
                    showToast("R.id.search")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.add -> {
                      val addFragment = AddFragment()
                        openFragment(addFragment)
                    showToast("R.id.add")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite -> {
                     val favoriteFragment = FavoriteFragment()
                        openFragment(favoriteFragment)
                    showToast("R.id.favorite")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    val profileFragment = ProfileFragment()
                        openFragment(profileFragment)
                    showToast("R.id.profile")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            android.R.anim.fade_in, android.R.anim.fade_out,
            android.R.anim.fade_in, android.R.anim.fade_out
        )
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (onFragmentBackPressed != null) {
            onFragmentBackPressed?.invoke()
            //remove callback on fragment replace
            onFragmentBackPressed = null
        } else {
            super.onBackPressed()
        }

    }
    private fun showToast(message : String){
        Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()

    }
}