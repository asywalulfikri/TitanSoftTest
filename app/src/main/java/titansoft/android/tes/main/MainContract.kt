package titansoft.android.tes.main

import com.androidnetworking.error.ANError
import titansoft.android.tes.base.BaseView

interface MainContract {
    interface BookView : BaseView {

        fun showProgress()
        fun hideProgress()
        fun goToMenu()
        fun showMessage(message : String)
    }

    interface ActionListener {
        fun tesConnection()
        fun onRequestSuccess(any: Any)
        fun onRequestFailed(error: ANError)
    }
}