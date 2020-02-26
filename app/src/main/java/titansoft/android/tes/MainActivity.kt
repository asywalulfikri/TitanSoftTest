package titansoft.android.tes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import titansoft.android.tes.base.BasePresenter
import titansoft.android.tes.main.MainContract
import titansoft.android.tes.main.MainPresenter
import titansoft.android.tes.menu.MenuActivity

class MainActivity : AppCompatActivity() , MainContract.BookView {

    private lateinit var mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainPresenter = MainPresenter()
        mainPresenter.attachView(this)

        btnTestConnection.setOnClickListener {
            mainPresenter.tesConnection()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showProgress() {
        btnTestConnection.isEnabled = false
       progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        btnTestConnection.isEnabled = true
        progressBar.visibility = View.GONE
    }

    override fun goToMenu() {
        Toast.makeText(this,"You are Connected",Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,MenuActivity::class.java))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
