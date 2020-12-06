package com.yasmen.smartangle.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasmen.smartangle.Adapters.RecyclerAdapter
import com.yasmen.smartangle.Model.itemsModel
import com.yasmen.smartangle.R
import com.yasmen.smartangle.Interfaces.RecyclerIndexInterface

class ProfileActivity : AppCompatActivity(), RecyclerIndexInterface {
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    var index = -1


    private val questionsList = listOf<itemsModel>(
        itemsModel("Question", "Message with a reply", "$3", false),
        itemsModel("Question", "Message only", "$2", false),
        itemsModel("Question", "Message with a reply with order", "$4", false)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        intializeControls()


    }

    private fun intializeControls() {
        recyclerView = findViewById(R.id.RecyclerV)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerAdapter = RecyclerAdapter(this@ProfileActivity as RecyclerIndexInterface, questionsList)
        recyclerView.adapter = recyclerAdapter
    }

    override fun setItemPosition(position: Int) {
        index = position
    }

    fun messageMeIndex(view: View) {
        Toast.makeText(this, "The index is $index", Toast.LENGTH_SHORT).show()
    }

}