// Donavan McFadden
// SDC340 Mobile App Development - Performance Assessment: Personal Photo Gallery App
// MainActivity = Splash Screen
// Shows my name + the app title "My Photo Gallery", then routes into the gallery.

package com.marching2more.photogallery

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.marching2more.photogallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // How long the splash screen stays on screen before moving to the gallery
    private val splashDelayMillis = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, GalleryActivity::class.java))
            finish()
        }, splashDelayMillis)
    }
}
