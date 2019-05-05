package com.bosch.presentation

interface DataRepository {
    var members: String?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()
}