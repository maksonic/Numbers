package com.maksonic.numbers.core.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * @Author: maksonic on 10.12.2021
 */
interface KeyboardBehavior {

    fun showKeyboard(view: View)
    fun hideKeyboard(view: View)

    class Base : KeyboardBehavior {
        override fun showKeyboard(view: View) {
            val keyboard =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val controller = ViewCompat.getWindowInsetsController(view)

            if (!view.isFocused) {
                view.requestFocus()
                keyboard.showSoftInput(view, 0)
                controller?.show(WindowInsetsCompat.Type.ime())
                (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .toggleSoftInput(
                        InputMethodManager.SHOW_IMPLICIT,
                        InputMethodManager.HIDE_IMPLICIT_ONLY
                    )
            }
        }

        override fun hideKeyboard(view: View) {
            val keyboard =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val controller = ViewCompat.getWindowInsetsController(view)

            if (view.hasFocus()) {
                view.clearFocus()
                keyboard.hideSoftInputFromWindow(view.windowToken, 0)
                controller?.hide(WindowInsetsCompat.Type.ime())
                (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(
                        view.windowToken,
                        InputMethodManager.HIDE_IMPLICIT_ONLY
                    )
            }
        }
    }
}