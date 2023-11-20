package com.example.betrayedcharacters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.betrayedcharacters.R
import com.example.betrayedcharacters.ui.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator3

class ImageSliderActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)

    //Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val skip = findViewById<Button>(R.id.skipbtn)
        postToList()

            //set the adapter in the view_pager
        val view_pager2 = findViewById<ViewPager2>(R.id.view_page2)
        view_pager2.adapter = ViewPagerAdapter(titlesList, descList, imagesList)

        val indiator = findViewById<CircleIndicator3>(R.id.indicator)
        indiator.setViewPager(view_pager2)

        skip.setOnClickListener {
            val i = Intent(this@ImageSliderActivity, MainActivity::class.java)
            startActivity(i)
        }


    }

    private fun addToList(title: String, desc: String, images: Int){
        titlesList.add(title)
        descList.add(desc)
        imagesList.add(images)


    }

    private fun postToList() {
        addToList(
            "Welcome",
            "this is harry potter books",
            R.drawable.hary
        )

        addToList(
            "Welcome",
            "this is harry 1",
            R.drawable.hary1
        )

        addToList(
            "Welcome",
            "this is harry threeee",
            R.drawable.harry3
        )
    }
}