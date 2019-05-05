package com.bosch.presentation

interface MemberView: BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: String)
}