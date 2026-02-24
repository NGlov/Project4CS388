package com.example.project4_ng

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonAdapter(private val context: Context, private val persons: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personImageView: ImageView = view.findViewById(R.id.personImageView)
        val personNameTextView: TextView = view.findViewById(R.id.personNameTextView)
        val knownForTextView: TextView = view.findViewById(R.id.knownForTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = persons[position]
        holder.personNameTextView.text = person.name
        holder.knownForTextView.text = "Known for: ${person.knownForDepartment}"

        val imageUrl = "https://image.tmdb.org/t/p/w500${person.profilePath}"
        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.personImageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("PERSON_EXTRA", person)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = persons.size
}