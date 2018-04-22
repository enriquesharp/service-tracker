package com.tracker.service.servicetrakcer.view.adapters

import android.app.Application
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.domain.EVENT_TYPE
import com.tracker.service.servicetrakcer.domain.EventLifecycleModel
import com.tracker.service.servicetrakcer.domain.EventModel
import com.urbamap.urbamap.extensions.inject
import kotlinx.android.synthetic.main.event_item_layout.view.*
import kotlinx.android.synthetic.main.event_lifecycle_item_layout.view.*

/**
 * Created by Enrique on 2/21/2018.
 */
class EventLifeCycleActionAdapter : RecyclerView.Adapter<EventLifeCycleActionAdapter.EventLifeCycleActionHolder>() {

    private val ctx by inject<Application>()
    var eventLifeCycleList: List<EventLifecycleModel> = listOf()

    private var onItemSelected: ((model: EventLifecycleModel) -> Unit)? = null
    fun onItemSelectedFun(onItemSelectedFun: ((model: EventLifecycleModel) -> Unit)?) {
        onItemSelected = onItemSelectedFun
    }

    fun setData(list: List<EventLifecycleModel>) {
        eventLifeCycleList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventLifeCycleActionHolder =
            EventLifeCycleActionHolder(LayoutInflater.from(ctx).inflate(R.layout.event_lifecycle_item_layout, parent, false))

    override fun onBindViewHolder(holder: EventLifeCycleActionHolder, position: Int) {
        val model = eventLifeCycleList[position]
        holder.itemView?.let { v ->
            v.topDivider.visibility = if (holder.adapterPosition == 0) View.INVISIBLE else View.VISIBLE
            v.eventLifecycleBox.setOnClickListener { onItemSelected?.invoke(model) }
            v.actionTv.text = model.typeName
        }
    }

    override fun getItemCount(): Int = eventLifeCycleList.size

    inner class EventLifeCycleActionHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}