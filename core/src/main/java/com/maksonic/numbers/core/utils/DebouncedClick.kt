package com.maksonic.numbers.core.utils

import android.os.SystemClock
import android.view.View

/**
 * @Author: maksonic on 10.12.2021
 */
fun View.click(debounceTime: Long = 600L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}
