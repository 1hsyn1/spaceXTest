package com.huseyinbulbul.spacex.presenter.iview

interface IBaseView {
    fun checkConnection(): Boolean
    fun showConnectionPopup()
    fun openActivity(cls: Class<*>)
    fun openActivityClearStack(cls: Class<*>)
    fun showLoading()
    fun hideLoading()
    fun hideKeyboard()
    fun snack(resId: Int)
}