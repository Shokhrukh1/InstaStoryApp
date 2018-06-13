package tk.opensourcedevelopment.instastoryapp.ui.base.presenter

import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseView

abstract class BasePresenterImpl<V : BaseView> constructor(protected val view: V) : BasePresenter