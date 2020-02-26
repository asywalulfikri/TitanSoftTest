package titansoft.android.tes.menu.itemInfo

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import titansoft.android.tes.R
import titansoft.android.tes.base.BaseActivity
import titansoft.android.tes.base.BasePresenter

class ItemInfoActivity : BaseActivity(),ItemInfoContract.ItemInfoView {

    private lateinit var itemInfoPresenter: ItemInfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(toolbar)
        setToolbar(toolbar)

        itemInfoPresenter= ItemInfoPresenter()
        itemInfoPresenter.attachView(this)
        itemInfoPresenter.getData()

    }
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, "Error $message",Toast.LENGTH_SHORT).show()
    }

    override fun setData(any: Any) {
        val detail: ItemInfoModel  = Gson().fromJson(any.toString(), ItemInfoModel::class.java)
        tvId.text = "Id : " + detail.id.toString()
        tvName.text = "Name : "+ detail.name
        tvDescription.text = "Description : "+detail.description
        tvValue.text = "Value : "+detail.value.toString()
        tvMoreDescription.text = "More Description : " +detail.itemDetail.moreDescription
        tvMaximum.text = "Maximum : "+convertPrice(detail.itemDetail.maximum)
        tvMinimum.text = "Minimum  : "+ detail.itemDetail.minimum.toString()


    }

    override fun setPresenter(presenter: BasePresenter<*>) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
