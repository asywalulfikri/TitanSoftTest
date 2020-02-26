package titansoft.android.tes.menu.itemInfo


import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.OkHttpResponseAndJSONObjectRequestListener
import okhttp3.Response
import org.json.JSONObject
import titansoft.android.tes.base.BasePresenter


class ItemInfoPresenter: BasePresenter<ItemInfoContract.ItemInfoView>(), ItemInfoContract.ActionListener {
    override fun getData() {

        view!!.showProgress()
        AndroidNetworking.post("http://entry-test.169mml.com/api/Test/GetBalance/getiteminfo/1")
            .setPriority(Priority.HIGH)
            .build()
            .getAsOkHttpResponseAndJSONObject(object : OkHttpResponseAndJSONObjectRequestListener {
                override fun onResponse(okHttpResponse: Response, response: JSONObject) {

                    view!!.hideProgress()
                    if(okHttpResponse.code()==200||okHttpResponse.code()==201){
                        onRequestSuccess(response)
                    }else{
                        onRequestFailed(response.hashCode())
                    }
                }
                override fun onError(anError: ANError) {
                    view!!.hideProgress()
                    onRequestFailed(anError.errorCode)
                }
            })
    }


    override fun onRequestSuccess(any: Any) {
        Log.d("success","1")
        view!!.setData(any)
    }

    override fun showErrorResponse(message: String?) {
        Log.d("erorrr",message)
    }

    override fun onRequestFailed(error: Int) {
        view!!.showError(error.toString())
    }


}