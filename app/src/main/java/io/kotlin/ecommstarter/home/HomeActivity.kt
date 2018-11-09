package io.kotlin.ecommstarter.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import dagger.android.AndroidInjection
import io.kotlin.ecommstarter.R
import kotlinx.android.synthetic.main.activity_feed.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_feed)
        homePresenter.startPresenting()
    }

    override fun onStop() {
        homePresenter.stopPresenting()
        super.onStop()
    }
}
