package tk.opensourcedevelopment.instastoryapp.data.preferences

interface PreferenceHelper {
    fun getUserName(): String
    fun setUserName(userName: String)
    fun getPassword(): String
    fun setPassword(password: String)
    fun isUserLoggedIn(): Boolean
    fun setUserLoggedIn(isUserLoggedIn: Boolean)
}