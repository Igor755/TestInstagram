package com.company.sonikplams.testinstagram.fragments_bottom_navigation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.sonikplams.testinstagram.R
import com.company.sonikplams.testinstagram.adapter.AdapterUser
import com.company.sonikplams.testinstagram.pojo.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import java.io.*


class HomeFragment : Fragment() {

    val list : ArrayList<User>  = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        readJson()
    }
    @SuppressLint("WrongConstant")
    fun readJson(){
        try {

            val jsonText = readText(activity!!.applicationContext, R.raw.jsonuser)
            val jsonarray = JSONArray(jsonText)

            for (i in 0 until jsonarray.length()) {
                val jsonobject = jsonarray.getJSONObject(i)
                val gson = Gson()
                val user: User = gson.fromJson(jsonobject.toString(), User::class.java)
                list.add(user)
            }

            val mAdapter = AdapterUser(list)
            rvNews!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
            rvNews!!.adapter = mAdapter

        }catch(e: IOException){

        }

    }

    @Throws(IOException::class)
    private fun readText(context: Context, resId: Int): String? {
        val `is`: InputStream = context.resources.openRawResource(resId)
        val br = BufferedReader(InputStreamReader(`is`))
        val sb = StringBuilder()
        var s: String? = null
        while (br.readLine().also { s = it } != null) {
            sb.append(s)
            sb.append("\n")
        }
        return sb.toString()
    }
}