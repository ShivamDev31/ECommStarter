package io.kotlin.ecommstarter.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.kotlin.ecommstarter.R
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AndroidInjection.inject(this)
        homePresenter.startPresenting()
    }

    override fun onStop() {
        homePresenter.stopPresenting()
        super.onStop()
    }
}
