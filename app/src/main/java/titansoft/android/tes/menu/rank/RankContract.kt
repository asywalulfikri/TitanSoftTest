package titansoft.android.tes.menu.rank

import titansoft.android.tes.base.BaseView

interface RankContract {
    interface RankView : BaseView {

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