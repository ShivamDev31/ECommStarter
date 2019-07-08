package io.kotlin.ecommstarter.home.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.kotlin.ecommstarter.home.viewstate.HomeViewState

abstract class HomeViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: HomeViewState.Type) :
        RecyclerView.ViewHolder(inflater.inflate(type.layoutId(), parent, false)) {

    abstract fun bind(viewState: HomeViewState)

    fun unbind() {
        // no op
    }
}
