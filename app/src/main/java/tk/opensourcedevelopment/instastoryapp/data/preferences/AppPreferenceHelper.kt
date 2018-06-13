package tk.opensourcedevelopment.instastoryapp.data.preferences

import android.content.Context
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(context: Context) : PreferenceHelper {
    companion object {
        private val PREF_KEY_USER_NAME = "PREF_KEY_USER_NAME"
        private val PREF_KEY_PASSWORD = "PREF_KEY_PASSWORD"
        private val PREF_IS_USER_LOGGED_IN = "PREF_IS_USER_LOGGED_IN"
        private val FILE_NAME = "store"
    }

    private val prefs = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override fun getUserName() = prefs.getString(PREF_KEY_USER_NAME, null)

    override fun setUserName(userName: String) {
        prefs.edit().putString(PREF_KEY_USER_NAME, userName).apply()
    }

    override fun getPassword() = prefs.getString(PREF_KEY_PASSWORD, null)

    override fun setPassword(password: String) {
        prefs.edit().putString(PREF_KEY_PASSWORD, password).apply()
    }

    override fun isUserLoggedIn() = prefs.getBoolean(PREF_IS_USER_LOGGED_IN, false)

    override fun setUserLoggedIn(isUserLoggedIn: Boolean) {
        prefs.edit().putBoolean(PREF_IS_USER_LOGGED_IN, isUserLoggedIn).apply()
    }
}