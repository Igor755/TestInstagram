package com.company.sonikplams.testinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.company.sonikplams.testinstagram.fragments_bottom_navigation.HomeFragment
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

    fun hideBottomNavigation() {
        with(bottomNavigation) {
            visibility = View.GONE
        }
        with(grey_line) {
            visibility = View.GONE
        }
    }

    fun showBottomNavigation() {
        with(bottomNavigation) {
            visibility = View.VISIBLE
        }
        with(grey_line) {
            visibility = View.VISIBLE
        }
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.search_auto -> {

                    /*val searchAutoFragment = SearchMainFragment()
                        openFragment(searchAutoFragment)*/
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite -> {
                    /*val favoriteFragment = FavoritesMainFragment()
                        openFragment(favoriteFragment)*/
                    return@OnNavigationItemSelectedListener true
                }
                R.id.my_deals -> {
                    /*  val dealsFragment = DealsMainFragment()
                        openFragment(dealsFragment)*/
                    return@OnNavigationItemSelectedListener true
                }
                R.id.message -> {

                    /* val messageFragment = ChatMainFragment()
                        openFragment(messageFragment)*/
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {

                    /*val profileFragment = ProfileMainFragment()
                        openFragment(profileFragment)*/
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
}