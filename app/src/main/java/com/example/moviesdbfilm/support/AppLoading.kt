package com.example.moviesdbfilm.support

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import com.example.moviesdbfilm.R

class AppLoading {

    fun create(activity: Activity): Dialog {
        val dialog = Dialog(activity, R.style.AppLoading)
        dialog.setOwnerActivity(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.loading_layout)
        dialog.setCancelable(false)

        val window = dialog.window
        window?.let {
            it.attributes.windowAnimations = R.style.AppLoading
            it.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
            it.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        return dialog
    }

    fun show(activity: Activity): Dialog {
        val dialog = create(activity)
        dialog.show()
        return dialog
    }
}