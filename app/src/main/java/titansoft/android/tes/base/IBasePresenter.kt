package titansoft.android.tes.base

interface IBasePresenter<in V : BaseView> {

    fun attachView(view: V)
    fun detachView()
}