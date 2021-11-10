package com.example.newsfeed.retrofit_files

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfeed.R

class MoviesAdapter(
    private val movies: List<Movie>,
    private val rowLayout: Int,
    private val context: Context
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var movieTitle: TextView = v.findViewById(R.id.title)
        internal var data: TextView = v.findViewById(R.id.subtitle)
        internal var movieDescription: TextView = v.findViewById(R.id.description)
        internal var rating: TextView = v.findViewById(R.id.rating)
        internal val art: ImageView = v.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val current = movies[position]
        holder.movieTitle.text = current.title
        holder.data.text = current.releaseDate
        holder.movieDescription.text = current.overview
        holder.rating.text = current.voteAverage!!.toString()
        val url = current.posterPath
        val siteArt = "https://image.tmdb.org/t/p/w500$url"
        Glide.with(context).load(siteArt).into(holder.art)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}