package io.kotlin.ecommstarter.home.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import io.kotlin.ecommstarter.home.viewstate.HomeViewState
import io.kotlin.ecommstarter.imageloader.ImageLoader

class AdBlockViewHolder(inflater: LayoutInflater, parent: ViewGroup, imageLoader: ImageLoader)
    : HomeViewHolder(inflater, parent, HomeViewState.Type.AD_BLOCK) {

    override fun bind(viewState: HomeViewState) {

    }
}
