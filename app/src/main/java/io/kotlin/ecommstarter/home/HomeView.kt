package io.kotlin.ecommstarter.home

import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.kotlin.ecommstarter.exts.hide
import io.kotlin.ecommstarter.exts.show
import io.kotlin.ecommstarter.home.adapter.HomeAdapter
import io.kotlin.ecommstarter.home.viewstate.HomeViewState
import io.kotlin.ecommstarter.imageloader.ImageLoader
import kotlinx.android.synthetic.main.activity_home.*

class HomeView(private val rvHome: RecyclerView, private val pbHome: ProgressBar, private val adapter: HomeAdapter) {

    companion object {

        fun from(activity: HomeActivity, imageLoader: ImageLoader): HomeView {
            val rvHome = activity.rvHome
            val pbHome = activity.pbHome
            val adapter = HomeAdapter(LayoutInflater.from(activity), imageLoader)
            rvHome.layoutManager = LinearLayoutManager(activity)
            rvHome.adapter = adapter
            return HomeView(rvHome, pbHome, adapter)
        }
    }

    fun show(homeViewStates: List<HomeViewState>) {
        rvHome.show()
        pbHome.hide()
        adapter.setViewStates(homeViewStates)
    }

    fun showLoading() {
        rvHome.hide()
        pbHome.show()
    }
}
