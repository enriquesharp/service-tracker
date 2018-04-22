package com.tracker.service.servicetrakcer.domain

enum class EVENT_TYPE { BUSSINESS, CONTACT, USER }
data class EventModel(
        val id: Int,
        val name: String,
        val address: String,
        val type: EVENT_TYPE,
        val time: Long,
        val status: Int
)

data class EventLifecycleModel(
        val type: EVENT_LIFE_CYCLE_ACTION_TYPE,
        val typeName: String
)

enum class EVENT_LIFE_CYCLE_ACTION_TYPE { END_GOING_TRAVEL, REPORT_ISSUES, TASK_DETAIL, TASK_DOCUMENT, START_TASK, START_PAUSE, REPORT_TEMP,
    START_SERVICE_GOING_TRAVEL, REPORT_SERVICE, COMING_BACK_TRAVEL_ENDED, SERVICE_RESUME, END_TASK, END_PAUSE, START_COMING_BACK_TRAVEL
}

