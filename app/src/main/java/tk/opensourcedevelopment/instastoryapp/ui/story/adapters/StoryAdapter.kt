package tk.opensourcedevelopment.instastoryapp.ui.story.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import tk.opensourcedevelopment.instastoryapp.R
import kotlinx.android.synthetic.main.item_story.view.*
import tk.opensourcedevelopment.instastoryapp.ui.base.OnItemClickListener
import tk.opensourcedevelopment.instastoryapp.util.extension.loadImage

class StoryAdapter(val listener: OnItemClickListener<InstagramFeedItem>, val stories: List<InstagramFeedItem>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)

        return StoryViewHolder(view)
    }

    override fun getItemCount() = stories.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(stories.get(position))
    }

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(story: InstagramFeedItem) {
            itemView.ivImage.loadImage(story.getImage_versions2().getCandidates().get(1).url)
            itemView.setOnClickListener {
                listener.onItemClick(stories.get(adapterPosition))
            }
        }
    }
}