package com.example.loadingdialog

import android.app.Activity
import androidx.appcompat.app.AlertDialog


internal class LoadingDialog(private val activity: Activity) {
    private var alertDialog: AlertDialog? = null

    fun displayDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.loading_dialog, null))
        builder.setCancelable(false)
        alertDialog = builder.create()
        alertDialog!!.show()
    }

    fun dismissDialog() {
        alertDialog!!.dismiss()
    }
}