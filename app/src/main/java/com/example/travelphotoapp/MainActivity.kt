package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

   private var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf("Paris", "Hawaii", "Greece", "Atlantic Ocean")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tVName)


        next.setOnClickListener{
            // i want to see the next image
            var idCurrentImageString = "pic$currentImage"

            // i want to get the integer address with each view
            var idCurrentImageInt = this.resources.getIdentifier(
                idCurrentImageString, "id", packageName
            )
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4+currentImage+1)%4
            var idImageToShowString = "pic$currentImage"

            var idImageToShowInt = this.resources.getIdentifier(
                idImageToShowString, "id", packageName
            )
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }

        prev.setOnClickListener{
            // i want to see the previous image
            var idCurrentImageString = "pic$currentImage"

            // i want to get the integer address with each view
            var idCurrentImageInt = this.resources.getIdentifier(
                idCurrentImageString, "id", packageName
            )
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4+currentImage-1)%4
            var idImageToShowString = "pic"+currentImage

            var idImageToShowInt = this.resources.getIdentifier(
                idImageToShowString, "id", packageName
            )
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }

    }
}