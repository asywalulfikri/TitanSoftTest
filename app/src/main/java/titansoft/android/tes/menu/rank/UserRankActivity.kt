package titansoft.android.tes.menu.rank

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import titansoft.android.tes.R
import kotlinx.android.synthetic.main.activity_rank.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import titansoft.android.tes.base.BaseActivity
import titansoft.android.tes.base.BasePresenter

class UserRankActivity : BaseActivity(),RankContract.RankView {

    private lateinit var rankPresenter: RankPresenter
    private lateinit var rankAdapter: RankAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)
        setSupportActionBar(toolbar)
        setToolbar(toolbar)

        rankPresenter = RankPresenter()
        rankPresenter.attachView(this)
        setupView()
        rankPresenter.getData()

    }


    private fun setupView(){
        val mLayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = mLayoutManager
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
        val arrayList : List<RankModel> = Gson().fromJson(any.toString(), Array<RankModel>::class.java).toList()
        rankAdapter = RankAdapter(arrayList,this)
        recyclerView!!.adapter = rankAdapter
        rankAdapter!!.notifyDataSetChanged()

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
