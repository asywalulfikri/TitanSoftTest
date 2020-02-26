package titansoft.android.tes.menu.rank

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import titansoft.android.tes.R


class RankAdapter(arrayList: List<RankModel>, context: Context) : RecyclerView.Adapter<RankAdapter.ViewHolder>() {

    private val contextt = context
    private var rankArrayList = arrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_rank, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rankModel = rankArrayList[position]!!

        holder.tvName.text = "Username : "+rankModel.username
        holder.tvRank.text = "Ranking : " +rankModel.ranking.toString()

    }

    override fun getItemCount(): Int {
        return rankArrayList.size
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tvPlayerName)
        var tvRank: TextView = view.findViewById(R.id.tvPlayerRank)


    }

}
