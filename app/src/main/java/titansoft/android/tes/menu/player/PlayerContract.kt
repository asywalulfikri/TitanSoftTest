package titansoft.android.tes.menu.player

import org.json.JSONArray
import titansoft.android.tes.base.BaseView

interface PlayerContract {
    interface PlayerView : BaseView {

        fun showProgress()
        fun hideProgress()
        fun showError(message : String)
        fun setData(jsonArray: JSONArray)
    }

    interface ActionListener {
        fun getData()
        fun onRequestSuccess(jsonArray: JSONArray)
        fun showErrorResponse(message: String?)
        fun onRequestFailed(error: Int)
    }
}