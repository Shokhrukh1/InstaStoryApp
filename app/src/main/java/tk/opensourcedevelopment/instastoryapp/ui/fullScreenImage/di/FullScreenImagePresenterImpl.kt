package tk.opensourcedevelopment.instastoryapp.ui.fullScreenImage.di

import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenterImpl
import javax.inject.Inject

class FullScreenImagePresenterImpl @Inject constructor(viewScreen: FullScreenImageView) : BasePresenterImpl<FullScreenImageView>(viewScreen), FullScreenImagePresenter {

}