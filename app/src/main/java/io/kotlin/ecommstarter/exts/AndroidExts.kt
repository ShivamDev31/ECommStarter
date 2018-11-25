package io.kotlin.ecommstarter.exts

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Context.toast(@StringRes text: Int) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}
