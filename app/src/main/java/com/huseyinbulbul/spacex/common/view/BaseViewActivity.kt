package com.huseyinbulbul.spacex.common.view

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.huseyinbulbul.spacex.R
import com.huseyinbulbul.spacex.presenter.iview.IBaseView
import kotlinx.android.synthetic.main.activity_base.*

open class BaseViewActivity: AppCompatActivity(), IBaseView {
    override fun setContentView(layoutResId: Int) {
        super.setContentView(R.layout.activity_base)

        var view = LayoutInflater.from(this).inflate(layoutResId, cl_container, false)
        cl_container.addView(view)
    }

    override fun checkConnection(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun showConnectionPopup() {
        AlertDialog.Builder(this)
                .setTitle(R.string.warning)
                .setMessage(R.string.no_connection)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialogInterface, i ->
                    startActivity(Intent(Settings.ACTION_SETTINGS))
                    dialogInterface.dismiss()
                })
                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialogInterface, i -> finish() })
                .show()
    }

    override fun openActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }

    override fun openActivityClearStack(cls: Class<*>) {
        val intent = Intent(this, cls)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    override fun showLoading() {
        cl_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        cl_loading.visibility = View.GONE
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    override fun snack(resId: Int) {
        Snackbar.make(cl_container, resId, Snackbar.LENGTH_LONG).show()
    }
}