package tk.opensourcedevelopment.instastoryapp.ui.welcome

import com.miguelcatalan.materialsearchview.MaterialSearchView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RxSearchObservable {
    companion object {
        fun fromView(searchView: MaterialSearchView): Observable<String> {
            val subject = PublishSubject.create<String>()

            searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    subject.onComplete()

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    subject.onNext(newText!!)

                    return true
                }
            })

            return subject
        }
    }
}