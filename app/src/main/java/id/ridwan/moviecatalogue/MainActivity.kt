package id.ridwan.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import id.ridwan.moviecatalogue.DetailMovie.Companion.KEY
//import id.ridwan.moviecatalogue.DetailMovie.Companion.KEY_DESC
//import id.ridwan.moviecatalogue.DetailMovie.Companion.KEY_NAME
//import id.ridwan.moviecatalogue.DetailMovie.Companion.KEY_PHOTO
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(this)
        list_movie.adapter = adapter

        prepare()
        additem()

        list_movie.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, movies[position].name, Toast.LENGTH_SHORT).show()

            val intent = Intent(this@MainActivity, DetailMovie::class.java)
            val moviie = Movie(
                movies[position].photo,
                movies[position].name,
                movies[position].description
            )

            intent.putExtra(KEY,moviie)
//            intent.putExtra(KEY_NAME,movies[position].name)
//            intent.putExtra(KEY_PHOTO,movies[position].photo)
//            intent.putExtra(KEY_DESC,movies[position].description)
            startActivity(intent)
//            val moviie = arrayListOf<Movie>().apply {
//                movies[position].name
//                movies[position].photo
//                movies[position].description
//            }

//            intent.putParcelableArrayListExtra(KEY,moviie)
        }
    }


    private fun prepare() {
        dataName = resources.getStringArray(R.array.movie_data)
        dataDescription = resources.getStringArray(R.array.movie_desc)
        dataPhoto = resources.obtainTypedArray(R.array.movie_photo)
    }

    private fun additem() {
        for (postion in dataName.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(postion, -1),
                dataName[postion],
                dataDescription[postion]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}





