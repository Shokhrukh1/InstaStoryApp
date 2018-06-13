package tk.opensourcedevelopment.instastoryapp.ui.story.di

import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseView

interface StoryView : BaseView {
    fun showStories(stories: List<InstagramFeedItem>)
}