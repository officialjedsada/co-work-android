package com.example.msigl62.coworkandroiduset.callapi

import com.example.msigl62.coworkandroiduset.InterActor
import com.example.msigl62.coworkandroiduset.model.Register
import com.example.msigl62.coworkandroiduset.network.BaseRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class Request : InterActor.ActData {
    override fun requestVerify(user: Register, callback: InterActor.OnFinishRequest) {
        BaseRetrofit.createRx()?.sendRequestVerify(user.facebook_id, user.name, user.email, user.password, user.image)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<Register>>() {
                    override fun onComplete() {}

                    override fun onNext(t: Response<Register>) {
                        t.body()?.let { callback.onSuccess(it) }
                    }

                    override fun onError(e: Throwable) {}
                })
    }

}