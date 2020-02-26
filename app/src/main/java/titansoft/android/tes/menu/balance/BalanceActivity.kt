package titansoft.android.tes.menu.balance

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_balance.*
import titansoft.android.tes.R

import kotlinx.android.synthetic.main.activity_rank.progressBar
import kotlinx.android.synthetic.main.layout_toolbar.*
import titansoft.android.tes.base.BaseActivity
import titansoft.android.tes.base.BasePresenter

class BalanceActivity : BaseActivity(),BalanceContract.BalanceView {

    private lateinit var balancePresenter: BalancePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        setSupportActionBar(toolbar)
        setToolbar(toolbar)

        balancePresenter= BalancePresenter()
        balancePresenter.attachView(this)
        balancePresenter.getData()

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
        val balance: BalanceModel  = Gson().fromJson(any.toString(), BalanceModel::class.java)
        tvType.text = balance.type
        tvStatus.text = balance.status.toString()
        tvTraceId.text = balance.traceId
        tvTitle.text = balance.title
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
