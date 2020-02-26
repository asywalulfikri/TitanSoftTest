package titansoft.android.tes.menu.itemInfo

import titansoft.android.tes.base.BaseView

interface ItemInfoContract {
    interface ItemInfoView : BaseView {

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