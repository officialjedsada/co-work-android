package com.example.msigl62.coworkandroiduset.ui.register

import com.example.msi_gl62.co_work_android_uset.R
import com.example.msigl62.coworkandroiduset.InterActor
import com.example.msigl62.coworkandroiduset.callapi.Request
import com.example.msigl62.coworkandroiduset.emailPattern
import com.example.msigl62.coworkandroiduset.model.Register

class RegisterPresenter(val view: RegisterContact.View) : RegisterContact.Presenter, InterActor.OnFinishRequest {
    private val actData: InterActor.ActData = Request()

    override fun requestValidateApi(model: Register) {
        actData.requestVerify(model, this)
    }

    override fun <T> onSuccess(t: T) {
        view.onResponseFromApi("success")
    }

    override fun checkEdiText(model: Register) {
        when {
            model.name.isNullOrEmpty() -> view.onErrorMessage(R.string.name_empty_message)
            model.name?.length ?: 0 > 60 -> view.onErrorMessage(R.string.name_longer_that_default)
            model.email.isNullOrEmpty() -> view.onErrorMessage(R.string.email_empty_massage)
            !model.email.emailPattern().matches() -> view.onErrorMessage(R.string.email_format_invalid)
            model.password.isNullOrEmpty() -> view.onErrorMessage(R.string.password_empty_massage)
            model.password?.length ?: 0 < 6 -> view.onErrorMessage(R.string.password_shorter_that_defaul)
            model.rePassword.isNullOrEmpty() -> view.onErrorMessage(R.string.re_password_empty_massage)
            !model.rePassword.equals(model.password) -> view.onErrorMessage(R.string.invalid_re_password)
            else -> {
                view.onSuccessValidated(model)
            }
        }
    }
}