package com.example.uberv.inheritance

class MapAppSettings : IAppSettings {

    companion object {
        private const val KEY_USERNAME = "username"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_TOKEN = "token"
    }

    private val map = mutableMapOf<String, Any?>()

    override var userName: String?
        get() = map[KEY_USERNAME] as String?
        set(value) {
            map[KEY_USERNAME] = value
        }
    override var isLoggedIn: Boolean?
        get() = map[KEY_IS_LOGGED_IN] as Boolean?
        set(value) {
            map[KEY_IS_LOGGED_IN] = value
        }
    override var token: String?
        get() = map[KEY_TOKEN] as String?
        set(value) {
            map[KEY_TOKEN] = value
        }
}