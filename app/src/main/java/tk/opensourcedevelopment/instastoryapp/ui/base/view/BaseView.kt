package tk.opensourcedevelopment.instastoryapp.ui.base.view

interface BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showMessage(message: String)
}