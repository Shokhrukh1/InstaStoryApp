package tk.opensourcedevelopment.instastoryapp.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import dev.niekirk.com.instagram4android.requests.payload.InstagramSearchUsersResultUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.toolbar.*
import tk.opensourcedevelopment.instastoryapp.R
import tk.opensourcedevelopment.instastoryapp.ui.base.OnItemClickListener
import tk.opensourcedevelopment.instastoryapp.ui.base.view.BaseActivity
import tk.opensourcedevelopment.instastoryapp.ui.story.StoryActivity
import tk.opensourcedevelopment.instastoryapp.ui.story.Constants.EXTRA_USER_ID
import tk.opensourcedevelopment.instastoryapp.ui.welcome.adapters.UserAdapter
import tk.opensourcedevelopment.instastoryapp.ui.welcome.di.WelcomeView
import tk.opensourcedevelopment.instastoryapp.ui.welcome.di.WelcomePresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WelcomeActivity : BaseActivity(), WelcomeView, OnItemClickListener<InstagramSearchUsersResultUser> {
    @Inject
    lateinit var presenter: WelcomePresenter
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        setSupportActionBar(toolbar)
        initSearchView()
        rvUsers.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(this)
        rvUsers.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        searchView.setMenuItem(menu?.findItem(R.id.search))

        return true
    }

    override fun onBackPressed() {
        if (searchView.isSearchOpen) {
            searchView.closeSearch()
        } else {
            super.onBackPressed()
        }
    }

    override fun onItemClick(item: InstagramSearchUsersResultUser) {
        val intent = Intent(this, StoryActivity::class.java)
        intent.putExtra(EXTRA_USER_ID, item.pk)
        startActivity(intent)
    }

    private fun initSearchView() {
        RxSearchObservable.fromView(searchView)
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter {
                    if (it.isEmpty())
                        false
                    else
                        true
                }
                .distinctUntilChanged()
                .switchMap {
                    presenter.searchUser(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.users = it.users
                    adapter.notifyDataSetChanged()
                    Log.d("myLogs", "${it.users.size}")
                }, {
                    Log.d("myLogs", it.message)
                })
    }
}