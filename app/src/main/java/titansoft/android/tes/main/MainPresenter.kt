package titansoft.android.tes.main

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.OkHttpResponseListener
import okhttp3.Response
import titansoft.android.tes.base.BasePresenter


class MainPresenter: BasePresenter<MainContract.BookView>(), MainContract.ActionListener {

    override fun tesConnection() {
        view!!.showProgress()
        AndroidNetworking.get("http://entry-test.169mml.com/api/Test/Get")
            .setPriority(Priority.HIGH)
            .build()
            .getAsOkHttpResponse(object  : OkHttpResponseListener{
                override fun onResponse(okHttpResponse: Response) {

                    view!!.hideProgress()
                    if(okHttpResponse.code()==200||okHttpResponse.code()==201){
                        onRequestSuccess(okHttpResponse.isSuccessful)
                    }
                }
                override fun onError(anError: ANError) {
                    view!!.hideProgress()
                    onRequestFailed(anError)
                }
            })

    }

    override fun onRequestSuccess(any: Any) {
        view!!.goToMenu()
    }

    override fun onRequestFailed(error:ANError) {
        view!!.showMessage("Error ${error.message}")
        Log.d("erornya",error.message)
    }


}