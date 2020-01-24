package id.ridwan.moviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter internal constructor(private val con : Context) : BaseAdapter(){
    internal var movies = arrayListOf<Movie>()

    override fun getView(position: Int, v: View?, vg: ViewGroup?): View {
       var movieView = v
        if(movieView == null){
            movieView = LayoutInflater.from(con).inflate(R.layout.item_movie,vg,false)
        }

        val vh = ViewHolder (movieView as View)

        val movie = getItem(position) as Movie
        vh.bind(movie)
        return movieView
    }
    override fun getItem(i: Int): Any = movies[i]
    override fun getItemId(i: Int): Long = i.toLong()
    override fun getCount(): Int = movies.size

    private inner class ViewHolder constructor(private val view: View) {
        fun bind(movie : Movie) {
            with(view){
                txt_name.text = movie.name
                txt_description.text = movie.description
                img_photo.setImageResource(movie.photo)
            }
        }
    }
}