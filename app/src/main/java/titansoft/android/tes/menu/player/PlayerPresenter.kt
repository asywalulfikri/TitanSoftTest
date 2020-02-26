package titansoft.android.tes.menu.player


import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.OkHttpResponseAndJSONArrayRequestListener
import com.androidnetworking.interfaces.OkHttpResponseAndJSONObjectRequestListener
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import titansoft.android.tes.base.BasePresenter


class PlayerPresenter: BasePresenter<PlayerContract.PlayerView>(), PlayerContract.ActionListener {
    override fun getData() {

        view!!.showProgress()
        AndroidNetworking.get("http://entry-test.169mml.com/api/Test/GetPlayers/getplayers")
            .setPriority(Priority.HIGH)
            .build()
            .getAsOkHttpResponseAndJSONArray(object  : OkHttpResponseAndJSONArrayRequestListener{
                override fun onResponse(okHttpResponse: Response, response: JSONArray) {

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
           /* .getAsOkHttpResponseAndJSONObject(object : OkHttpResponseAndJSONObjectRequestListener {
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
            })*/
    }



    override fun onRequestSuccess(jsonArray: JSONArray) {
        Log.d("success","1")
        view!!.setData(jsonArray)
    }

    override fun showErrorResponse(message: String?) {
        Log.d("erorrr",message)
    }

    override fun onRequestFailed(error: Int) {
        view!!.showError(error.toString())
    }


}