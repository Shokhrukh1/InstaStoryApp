package tk.opensourcedevelopment.instastoryapp.ui.video

import android.os.Bundle
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.jarvanmo.exoplayerview.media.SimpleMediaSource
import kotlinx.android.synthetic.main.activity_video.*
import tk.opensourcedevelopment.instastoryapp.R
import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseActivity
import tk.opensourcedevelopment.instastoryapp.ui.video.Constants.EXTRA_VIDEO_URL
import tk.opensourcedevelopment.instastoryapp.ui.video.di.VideoPresenter
import tk.opensourcedevelopment.instastoryapp.ui.video.di.VideoView
import javax.inject.Inject

class VideoActivity : BaseActivity(), VideoView {
    @Inject
    lateinit var presenter: VideoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        playVideo(intent.getStringExtra(EXTRA_VIDEO_URL))
    }

    override fun playVideo(url: String) {
        videoView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH)
        videoView.play(SimpleMediaSource(url))
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.releasePlayer()
    }
}
