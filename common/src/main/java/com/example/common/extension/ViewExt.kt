package com.example.common.extension

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.common.R
import com.example.common.utils.Event


lateinit var dialog: AlertDialog


fun Fragment.showErrorDialog(errorText: String) {
    activity?.let {
        AlertDialog.Builder(context)
            .setMessage(errorText)
            .setPositiveButton(android.R.string.yes) { _, _ -> }
            .show()
    }
}

fun Fragment.setupErrorStringDialog(
    lifecycleOwner: LifecycleOwner,
    errorDialogStringEvent: LiveData<Event<String>>
) {
    errorDialogStringEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { error ->
            context?.let { showErrorDialog(error) }
        }
    })
}

fun Fragment.showProgressDialog() {
    activity?.let {
        if (::dialog.isInitialized && !(context as Activity).isFinishing && !dialog.isShowing) {
            dialog.show()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

    }
}

fun Fragment.hideProgressDialog() {
    activity?.let {
        try {
            if (::dialog.isInitialized && !(context as Activity).isFinishing && dialog.isShowing) dialog.dismiss()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun Fragment.setupProgressDialog(
    lifecycleOwner: LifecycleOwner,
    progressDialogEvent: LiveData<Event<Boolean>>
) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setCancelable(false)
    builder.setView(R.layout.loading_dialog)
    dialog = builder.create()
    progressDialogEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { isShow ->
            context?.let {
                if (isShow) {
                    showProgressDialog()
                } else {
                    hideProgressDialog()
                }
            }
        }
    })
}
