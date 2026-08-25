// Donavan McFadden
// SDC340 Mobile App Development - Performance Assessment: Personal Photo Gallery App
// ImageDetailActivity = Secondary Activity
// Shows a single photo enlarged after the user taps a thumbnail in GalleryActivity.

package com.marching2more.photogallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marching2more.photogallery.databinding.ActivityImageDetailBinding

class ImageDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IMAGE_RES_ID = "extra_image_res_id"
        const val EXTRA_IMAGE_CAPTION = "extra_image_caption"
    }

    private lateinit var binding: ActivityImageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageResId = intent.getIntExtra(EXTRA_IMAGE_RES_ID, R.drawable.photo_family)
        val caption = intent.getStringExtra(EXTRA_IMAGE_CAPTION).orEmpty()

        binding.imageFullView.setImageResource(imageResId)
        binding.textCaption.text = caption

        // Back arrow in the action bar returns to the gallery grid
        supportActionBar?.apply {
            title = getString(R.string.detail_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
