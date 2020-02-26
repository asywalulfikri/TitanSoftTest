package titansoft.android.tes.menu.balance

import titansoft.android.tes.base.BaseView

interface BalanceContract {
    interface BalanceView : BaseView {

        fun showProgress()
        fun hideProgress()
        fun showError(message : String)
        fun setData(any: Any)
    }

    interface ActionListener {
        fun getData()
        fun onRequestSuccess(any: Any)
        fun showErrorResponse(message: String?)
        fun onRequestFailed(error: Int)
    }
}