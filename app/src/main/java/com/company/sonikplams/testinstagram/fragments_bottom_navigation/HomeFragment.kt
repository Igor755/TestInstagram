package com.company.sonikplams.testinstagram.fragments_bottom_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.company.sonikplams.testinstagram.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    fun readJson(){
        var json : String? = null
        try {
            val inputStream : InputStream = activity?.assets!!.open("jsonuser.json")
            json = inputStream.bufferedReader().use(BufferedReader::readText)

        }catch(e: IOException){

        }

    }
}