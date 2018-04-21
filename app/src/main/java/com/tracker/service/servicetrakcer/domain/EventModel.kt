package com.tracker.service.servicetrakcer.domain

data class EventModel(
        val id: Int,
        val name: String,
        val address: String,
        val type: EVENT_TYPE,
        val time: Long,
        val status: Int
)

enum class EVENT_TYPE { BUSSINESS, CONTACT, USER }