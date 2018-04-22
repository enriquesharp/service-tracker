package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.domain.EVENT_LIFE_CYCLE_ACTION_TYPE
import com.tracker.service.servicetrakcer.domain.EventLifecycleModel
import com.tracker.service.servicetrakcer.view.adapters.EventLifeCycleActionAdapter
import kotlinx.android.synthetic.main.lifecycle_actions_fragment.*

class LifecycleActionsFragment : BaseFragment() {

    enum class LIFE_CYCLE { GOING_TRAVEL_STARTED, GOING_TRAVEL_ENDED, IN_PROCESS_TASK, IN_PAUSED_TASK, ENDED_TASK, COMING_BACK_TRAVEL_STARTED, ENDED_TASK_BUT}

    var lifeCycleStatus = LIFE_CYCLE.GOING_TRAVEL_STARTED

    companion object {
        fun newInstance(): LifecycleActionsFragment = LifecycleActionsFragment()
    }

    private var onItemSelected: ((model: EventLifecycleModel) -> Unit)? = null
    fun onItemSelectedFun(onItemSelectedFun: ((model: EventLifecycleModel) -> Unit)?) {
        onItemSelected = onItemSelectedFun
    }

    val eventLifecycleAdapter by lazy {
        EventLifeCycleActionAdapter().apply {
            onItemSelectedFun {
                setTaskItemSelectedAction(it)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.lifecycle_actions_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleActionsRv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = eventLifecycleAdapter
        }
        setData()
    }

    private fun setTaskItemSelectedAction(eventLifecycleModel: EventLifecycleModel) {
        when (eventLifecycleModel.type) {
            EVENT_LIFE_CYCLE_ACTION_TYPE.END_GOING_TRAVEL -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.START_TASK -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.START_PAUSE -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.START_SERVICE_GOING_TRAVEL -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_TEMP -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.END_TASK -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.SERVICE_RESUME -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.END_PAUSE -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_SERVICE -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.START_COMING_BACK_TRAVEL -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
            EVENT_LIFE_CYCLE_ACTION_TYPE.COMING_BACK_TRAVEL_ENDED -> {
                onItemSelected?.invoke(eventLifecycleModel)
            }
        }
    }

    fun setData() {
        when (lifeCycleStatus) {
            LIFE_CYCLE.GOING_TRAVEL_STARTED -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.END_GOING_TRAVEL, getString(R.string.action_end_going_task_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES, getString(R.string.action_report_issue_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_going_travel_started_text).capitalize()
                actionSubTitle.visibility = View.GONE
            }
            LIFE_CYCLE.GOING_TRAVEL_ENDED -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.START_TASK, getString(R.string.action_start_task_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES, getString(R.string.action_report_issue_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_going_travel_ended_text).capitalize()
                actionSubTitle.visibility = View.GONE
            }
            LIFE_CYCLE.IN_PROCESS_TASK -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES, getString(R.string.action_report_issue_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.START_PAUSE, getString(R.string.action_start_pause_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.START_SERVICE_GOING_TRAVEL, getString(R.string.action_report_temp_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_TEMP, getString(R.string.action_document_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.END_TASK, getString(R.string.action_end_task_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_in_process_task_text).capitalize()
                actionSubTitle.visibility = View.GONE
            }
            LIFE_CYCLE.IN_PAUSED_TASK -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES, getString(R.string.action_report_issue_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.SERVICE_RESUME, getString(R.string.action_service_resume_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.END_PAUSE, getString(R.string.action_end_pause_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_in_pause_task_text).capitalize()
                actionSubTitle.visibility = View.GONE
            }
            LIFE_CYCLE.ENDED_TASK -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES, getString(R.string.action_report_issue_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_SERVICE, getString(R.string.action_service_report_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.START_COMING_BACK_TRAVEL, getString(R.string.action_start_coming_back_travel_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_ended_task_text).capitalize()
                actionSubTitle.visibility = View.GONE
            }
            LIFE_CYCLE.COMING_BACK_TRAVEL_STARTED -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_ISSUES, getString(R.string.action_report_issue_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.REPORT_SERVICE, getString(R.string.action_service_report_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.COMING_BACK_TRAVEL_ENDED, getString(R.string.action_coming_back_travel_ended_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_coming_back_travel_started_text).capitalize()
                actionSubTitle.visibility = View.GONE
            }
            LIFE_CYCLE.ENDED_TASK_BUT -> {
                val list = listOf(
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DETAIL, getString(R.string.action_task_detail_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.TASK_DOCUMENT, getString(R.string.action_document_text)),
                        EventLifecycleModel(EVENT_LIFE_CYCLE_ACTION_TYPE.SERVICE_RESUME, getString(R.string.action_service_resume_text))
                )
                eventLifecycleAdapter.setData(list)
                actionTitle.text = getString(R.string.status_ended_task_but_text).capitalize()
                actionSubTitle.visibility = View.VISIBLE
            }
        }
    }


}