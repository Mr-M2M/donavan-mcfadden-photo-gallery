// Donavan McFadden
// SDC340 Mobile App Development - Performance Assessment: Personal Photo Gallery App
// GalleryActivity = Main Activity
// Displays 6 thumbnail images. Tapping any thumbnail opens ImageDetailActivity
// with a larger version of that image.

package com.marching2more.photogallery

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.marching2more.photogallery.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Action bar title + custom launcher icon next to the title
        supportActionBar?.apply {
            title = getString(R.string.gallery_title)
            setIcon(R.mipmap.ic_launcher)
            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
        }
    }

    /**
     * Shared onClick handler (wired from activity_gallery.xml android:onClick)
     * for all 6 thumbnails. Opens ImageDetailActivity with the full-size
     * drawable resource id and a caption for that photo.
     */
    fun onThumbnailClick(view: View) {
        val (resId, caption) = when (view.id) {
            R.id.imageThumb1 -> R.drawable.photo_marching to getString(R.string.img_1_desc)
            R.id.imageThumb2 -> R.drawable.photo_family to getString(R.string.img_2_desc)
            R.id.imageThumb3 -> R.drawable.photo_new_home to getString(R.string.img_3_desc)
            R.id.imageThumb4 -> R.drawable.photo_skyline to getString(R.string.img_4_desc)
            R.id.imageThumb5 -> R.drawable.photo_closing_day to getString(R.string.img_5_desc)
            else -> R.drawable.photo_sunrise_road to getString(R.string.img_6_desc)
        }

        val intent = Intent(this, ImageDetailActivity::class.java).apply {
            putExtra(ImageDetailActivity.EXTRA_IMAGE_RES_ID, resId)
            putExtra(ImageDetailActivity.EXTRA_IMAGE_CAPTION, caption)
        }
        startActivity(intent)
    }
}
