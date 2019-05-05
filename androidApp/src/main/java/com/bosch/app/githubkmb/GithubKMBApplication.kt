package com.bosch.app.githubkmb

import android.app.Application
import com.bosch.api.GithubAPI
import com.bosch.model.MembersDataRepository
import com.bosch.presentation.DataRepository

public class GithubKMBApplication: Application() {
    val dataRepository: DataRepository by lazy {
        MembersDataRepository(GithubAPI())
    }
}