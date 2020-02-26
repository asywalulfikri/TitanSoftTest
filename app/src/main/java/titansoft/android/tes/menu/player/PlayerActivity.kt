package titansoft.android.tes.menu.player

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_player.*
import kotlinx.android.synthetic.main.activity_rank.progressBar
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.json.JSONArray
import titansoft.android.tes.R
import titansoft.android.tes.base.BaseActivity
import titansoft.android.tes.base.BasePresenter


class PlayerActivity : BaseActivity(),PlayerContract.PlayerView {

    private lateinit var playerPresenter: PlayerPresenter
    private var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        setSupportActionBar(toolbar)
        setToolbar(toolbar)

        playerPresenter = PlayerPresenter()
        playerPresenter.attachView(this)
        playerPresenter.getData()

    }


    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, "Error $message", Toast.LENGTH_SHORT).show()
    }

    override fun setData(jsonArray: JSONArray) {

        for (i in 0 until jsonArray.length()) {
            var value: String = jsonArray.getString(i).toString()
           // Log.e("json", "$i=$value")
            //tvName.text = value
            list.add(value)
        }


        recyclerView.adapter = ArrayAdapter<String>(
            this,
            R.layout.list_item_player,
            R.id.tvName,
            list
        )



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

