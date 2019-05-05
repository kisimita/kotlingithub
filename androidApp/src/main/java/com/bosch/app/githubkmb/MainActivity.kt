package com.bosch.app.githubkmb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bosch.api.UpdateProblems
import com.bosch.model.Member
import com.bosch.platformName
import com.bosch.presentation.MemberView
import com.bosch.presentation.MembersPresenter

class MainActivity : AppCompatActivity(), MemberView {
    override var isUpdating = false

    override fun onUpdate(members: List<Member>) {
        runOnUiThread {
            Toast.makeText(this, "Size:" + members.size, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(error: Throwable) {
        val errorMessage = when (error) {
            is UpdateProblems -> "Fail to get data from server"
            else -> "Unknow error"
        }
        runOnUiThread {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private val repository by lazy {(application as GithubKMBApplication).dataRepository}
    private val presenter by lazy { MembersPresenter(this, repository = repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG", "This is platform name:${platformName()}")

        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
