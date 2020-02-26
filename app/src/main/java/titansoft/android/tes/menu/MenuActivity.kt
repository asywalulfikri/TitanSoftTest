package titansoft.android.tes.menu

import android.content.Intent
import android.os.Bundle
import titansoft.android.tes.R

import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.content_menu.*
import titansoft.android.tes.base.BaseActivity
import titansoft.android.tes.menu.balance.BalanceActivity
import titansoft.android.tes.menu.itemInfo.ItemInfoActivity
import titansoft.android.tes.menu.player.PlayerActivity
import titansoft.android.tes.menu.rank.UserRankActivity

class MenuActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)
        setToolbar(toolbar)

        btnGetPlayer.setOnClickListener {
            startActivity(Intent(this,PlayerActivity::class.java))
        }

        btnGetRank.setOnClickListener {
            startActivity(Intent(this,UserRankActivity::class.java))
        }

        btnGetBalance.setOnClickListener {
            startActivity(Intent(this,BalanceActivity::class.java))
        }

        btnGetItemInfo.setOnClickListener {
            startActivity(Intent(this,ItemInfoActivity::class.java))
        }


    }

}
