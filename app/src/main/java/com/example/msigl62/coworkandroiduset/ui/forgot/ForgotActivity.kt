package com.example.msigl62.coworkandroiduset.ui.forgot

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.msi_gl62.co_work_android_uset.R
import com.example.msigl62.coworkandroiduset.extension.navigate
import com.example.msigl62.coworkandroiduset.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_forgot.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@Suppress("DEPRECATION")
class ForgotActivity : AppCompatActivity(), ForgotContact.View {
    private val presenter: ForgotContact.Presenter = ForgotPresenter(this)
    private var loadingDialog: ProgressDialog? = null

    override fun onSuccessValidated(email: String) {
        loadingDialog = ProgressDialog.show(this,
                "Loading",
                "Loading...",
                true,
                false)
        presenter.requestValidateApi(email)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        setToolBar()
        setButtonSubmitForgotPassword()
    }

    private fun setToolBar() {
        image_arrow.setOnClickListener {
            navigate<LoginActivity> {  }
        }
    }

    override fun onErrorMessage(err: Int) {
        Toast.makeText(this, applicationContext.getText(err), Toast.LENGTH_SHORT).show()
    }

    override fun onResponseFromApi(resMessage: String) {
        loadingDialog?.dismiss()
        when (resMessage) {
            "false" -> Toast.makeText(this, R.string.toastResponseForgot, Toast.LENGTH_SHORT).show()
            "statusFalse" -> Toast.makeText(this, R.string.statusFalseConfirmSingUp, Toast.LENGTH_SHORT).show()
            else -> {
                navigate<ForgotActivityFinish> {  }
            }
        }
    }

    private fun setButtonSubmitForgotPassword() {
        btnSubmitForgot.setOnClickListener {
            presenter.checkEdiText(edt_forgot_email.text.trim().toString())
        }
    }
}
