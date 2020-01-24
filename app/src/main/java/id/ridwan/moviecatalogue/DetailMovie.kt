package id.ridwan.moviecatalogue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailMovie : AppCompatActivity() {

    companion object {
        const val KEY = "key"
//        const val KEY_NAME = "key_name"
//        const val KEY_PHOTO = "key_photo"
//        const val KEY_DESC = "key_desc"
    }

    private var photop:Int = 0
    private var namae: String? = null
    private var descd: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val name = findViewById<TextView>(R.id.name)
        val photo = findViewById<ImageView>(R.id.img_photo2)
        val desc = findViewById<TextView>(R.id.desc)

        val moviie = intent.getParcelableExtra(KEY) as Movie

        val photop = moviie.photo
        val namae = moviie.name
        val descd = moviie.description

        Glide.with(this).load(photop).override(350, 550).into(photo)
        name.text = namae
        desc.text = descd
//        namae = intent.getStringExtra(KEY_NAME)
//        photop = intent.getIntExtra(KEY_PHOTO,0)
//        descd = intent.getStringExtra(KEY_DESC)

//        val getData = intent.getParcelableArrayListExtra<>(KEY) as ArrayList<Movie>

    }
}
