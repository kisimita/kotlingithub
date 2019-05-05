package com.bosch.presentation

import com.bosch.model.Member

interface MemberView: BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: List<Member>)
}