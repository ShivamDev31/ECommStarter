package io.kotlin.ecommstarter.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.kotlin.ecommstarter.home.holder.HomeViewHolder
import io.kotlin.ecommstarter.home.holder.ProductListViewHolder
import io.kotlin.ecommstarter.home.holder.ProductSliderViewHolder
import io.kotlin.ecommstarter.home.viewstate.HomeViewState
import io.kotlin.ecommstarter.home.viewstate.HomeViewState.Type.PRODUCTS_LIST
import io.kotlin.ecommstarter.home.viewstate.HomeViewState.Type.SLIDER_PRODUCT

class HomeAdapter(private val inflater: LayoutInflater) : RecyclerView.Adapter<HomeViewHolder>() {

    private val viewStates = mutableListOf<HomeViewState>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val type = HomeViewState.Type.from(viewType)
        return when (type) {
            SLIDER_PRODUCT -> ProductSliderViewHolder(inflater, parent)
            PRODUCTS_LIST -> ProductListViewHolder(inflater, parent)
        }
    }

    override fun getItemCount() = viewStates.size

    override fun getItemViewType(position: Int): Int {
        val viewState = viewStates[position]
        val type = viewState.type()
        return type.values()
    }

    fun setViewStates(viewStates: List<HomeViewState>) {
        this.viewStates.clear()
        this.viewStates.addAll(viewStates)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(viewStates[position])
    }

    override fun onViewRecycled(holder: HomeViewHolder) {
        holder.unbind()
    }

}
