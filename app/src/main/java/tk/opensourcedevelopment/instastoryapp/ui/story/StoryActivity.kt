package tk.opensourcedevelopment.instastoryapp.ui.story

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import kotlinx.android.synthetic.main.activity_story.*
import tk.opensourcedevelopment.instastoryapp.R
import tk.opensourcedevelopment.instastoryapp.ui.base.OnItemClickListener
import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseActivity
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.Constants.EXTRA_IMAGE_URL
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.FullScreenImageActivity
import tk.opensourcedevelopment.instastoryapp.ui.story.adapters.StoryAdapter
import tk.opensourcedevelopment.instastoryapp.ui.story.di.StoryPresenter
import tk.opensourcedevelopment.instastoryapp.ui.story.di.StoryView
import tk.opensourcedevelopment.instastoryapp.ui.story.Constants.EXTRA_USER_ID
import tk.opensourcedevelopment.instastoryapp.ui.video.Constants.EXTRA_VIDEO_URL
import tk.opensourcedevelopment.instastoryapp.ui.video.VideoActivity
import javax.inject.Inject

class StoryActivity : BaseActivity(), StoryView, OnItemClickListener<InstagramFeedItem> {
    @Inject
    lateinit var presenter: StoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        rvStories.layoutManager = GridLayoutManager(this,3)
        presenter.getStories(intent.getLongExtra(EXTRA_USER_ID, 0))
    }

    override fun showStories(stories: List<InstagramFeedItem>) {
        rvStories.adapter = StoryAdapter(this, stories)
    }

    override fun onItemClick(item: InstagramFeedItem) {
        when (item.media_type) {
            1 -> {
                val intent = Intent(this, FullScreenImageActivity::class.java)
                intent.putExtra(EXTRA_IMAGE_URL, item.getImage_versions2().candidates.get(0).url)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, VideoActivity::class.java)
                intent.putExtra(EXTRA_VIDEO_URL, item.video_versions.get(0).url)
                startActivity(intent)
            }
        }
    }
}
