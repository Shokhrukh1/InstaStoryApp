package tk.opensourcedevelopment.instastoryapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_login.*
import tk.opensourcedevelopment.instastoryapp.R
import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseActivity
import tk.opensourcedevelopment.instastoryapp.ui.login.di.LoginPresenter
import tk.opensourcedevelopment.instastoryapp.ui.login.di.LoginView
import tk.opensourcedevelopment.instastoryapp.ui.welcome.WelcomeActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {
    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        hideProgressBar()
        presenter.checkUserLoggedIn()

        btnSignIn.setOnClickListener { view ->
            presenter.login(etLogin.text.toString(), etPassword.text.toString())
        }

        etPassword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.login(etLogin.text.toString(), etPassword.text.toString())

                true
            }

            false
        }
    }

    override fun openWelcomeActivity() {
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}