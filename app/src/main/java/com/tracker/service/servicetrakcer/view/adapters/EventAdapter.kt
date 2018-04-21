package com.tracker.service.servicetrakcer.view.adapters

import android.app.Application
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.domain.EVENT_TYPE
import com.tracker.service.servicetrakcer.domain.EventModel
import com.urbamap.urbamap.extensions.inject
import kotlinx.android.synthetic.main.event_item_layout.view.*

/**
 * Created by Enrique on 2/21/2018.
 */
class EventAdapter : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    private val ctx by inject<Application>()
    var eventList: List<EventModel> = listOf()

    fun setData(list: List<EventModel>) {
        eventList = list
        eventList = listOf(
                EventModel(1, "Event 1", "Direction 1", EVENT_TYPE.BUSSINESS, 5, 0),
                EventModel(1, "Event 2", "Direction 2", EVENT_TYPE.USER, 10, 0),
                EventModel(1, "Event 3", "Direction 3", EVENT_TYPE.CONTACT, 30, 0)
        )
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder =
            EventHolder(LayoutInflater.from(ctx).inflate(R.layout.event_item_layout, parent, false))

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val model = eventList[position]
        holder.itemView?.let { v ->
            v.nameTv.text = model.name
            v.imageType.setImageResource(when (model.type) {
                EVENT_TYPE.BUSSINESS -> R.drawable.business_icon
                EVENT_TYPE.USER -> R.drawable.contacts_icon
                EVENT_TYPE.CONTACT -> R.drawable.contacts_icon
            })
            v.addressTv.text = model.address
            v.timeTv.text = "${model.time}"
        }
    }

    override fun getItemCount(): Int = eventList.size

    inner class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}