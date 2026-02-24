package com.example.project4_ng

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val person = intent.getSerializableExtra("PERSON_EXTRA") as Person

        val nameTextView: TextView = findViewById(R.id.detailNameTextView)
        val departmentTextView: TextView = findViewById(R.id.detailDepartmentTextView)
        val popularityTextView: TextView = findViewById(R.id.detailPopularityTextView)
        val personImageView: ImageView = findViewById(R.id.detailPersonImageView)
        val knownForImageView: ImageView = findViewById(R.id.knownForImageView)
        val knownForTitleTextView: TextView = findViewById(R.id.knownForTitleTextView)
        val knownForOverviewTextView: TextView = findViewById(R.id.knownForOverviewTextView)

        nameTextView.text = person.name
        departmentTextView.text = "Department: ${person.knownForDepartment}"
        popularityTextView.text = "Popularity: ${person.popularity}"

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${person.profilePath}")
            .into(personImageView)

        // Display details of the first "known for" item
        if (person.knownFor.isNotEmpty()) {
            val firstWork = person.knownFor[0]
            knownForTitleTextView.text = firstWork.displayTitle
            knownForOverviewTextView.text = firstWork.overview

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500${firstWork.posterPath}")
                .into(knownForImageView)
        }
    }
}