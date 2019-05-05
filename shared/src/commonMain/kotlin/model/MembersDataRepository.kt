package com.bosch.model

import com.bosch.api.GithubAPI
import com.bosch.api.UpdateProblems
import com.bosch.presentation.DataRepository

class MembersDataRepository(private val api: GithubAPI): DataRepository {
    override var members: String? = null
    override var onRefreshListeners: List<() -> Unit> = emptyList()

    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        } catch (cause: Throwable) {
            throw UpdateProblems()
        }

        if (newMembers != members) {
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners() {
        onRefreshListeners.forEach { it() }
    }

}