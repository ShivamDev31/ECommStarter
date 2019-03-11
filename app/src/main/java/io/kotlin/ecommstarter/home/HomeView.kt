package io.kotlin.ecommstarter.home

import android.widget.ProgressBar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import io.kotlin.ecommstarter.exts.hide
import io.kotlin.ecommstarter.exts.show
import io.kotlin.ecommstarter.home.adapter.HomeAdapter
import io.kotlin.ecommstarter.home.viewstate.HomeViewState
import kotlinx.android.synthetic.main.activity_home.pbHome
import kotlinx.android.synthetic.main.activity_home.rvHome

class HomeView(private val rvHome: RecyclerView, private val pbHome: ProgressBar, private val adapter: HomeAdapter) {

    companion object {

        fun from(activity: HomeActivity, homeAdapter: HomeAdapter): HomeView {
            val rvHome = activity.rvHome
            val pbHome = activity.pbHome
            val dividerItemDecoration = DividerItemDecoration(activity, VERTICAL)
            val itemAnimator = DefaultItemAnimator()
            itemAnimator.supportsChangeAnimations = false
            rvHome.addItemDecoration(dividerItemDecoration)
            rvHome.layoutManager = LinearLayoutManager(activity)
            rvHome.adapter = homeAdapter
            return HomeView(rvHome, pbHome, homeAdapter)
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
