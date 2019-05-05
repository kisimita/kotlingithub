package com.bosch.presentation

import com.bosch.model.Member

interface DataRepository {
    var members: List<Member>?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()
}