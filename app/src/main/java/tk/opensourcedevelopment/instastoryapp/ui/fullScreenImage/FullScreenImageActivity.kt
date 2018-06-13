package tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_full_screen_image.*
import tk.opensourcedevelopment.instastoryapp.R
import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseActivity
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.Constants.EXTRA_IMAGE_URL
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.di.FullScreenImagePresenter
import tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.di.FullScreenImageView
import tk.opensourcedevelopment.instastoryapp.util.extension.loadImage
import javax.inject.Inject

class FullScreenImageActivity : BaseActivity(), FullScreenImageView {
    @Inject
    lateinit var presenter: FullScreenImagePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        ivImage.loadImage(intent.getStringExtra(EXTRA_IMAGE_URL))
    }
}
