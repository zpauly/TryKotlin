package com.zpauly.trykotlin.utils

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zpauly on 2016/12/25.
 */

fun Context.showSnackbar(view: View, resId: Int, length: Int = Snackbar.LENGTH_SHORT) {
    showSnackbar(view, resId, length)
}

fun Context.showSnackbar(view: View, text: CharSequence, length: Int = Snackbar.LENGTH_SHORT) {
    showSnackbar(view, text, length)
}

fun Fragment.showSnackbar(view: View, resId: Int, length: Int = Snackbar.LENGTH_SHORT) {
    snackbar(view, resId, length)
}

fun Fragment.showSnackbar(view: View, text: CharSequence, length: Int = Snackbar.LENGTH_SHORT) {
    snackbar(view, text, length)
}

fun snackbar(view: View, text: CharSequence, length: Int) {
    Snackbar.make(view, text, length).show()
}

fun snackbar(view: View, resId: Int, length: Int) {
    Snackbar.make(view, resId, length).show()
}

fun ViewGroup.inflate(layout: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layout, this, attachToRoot)
}