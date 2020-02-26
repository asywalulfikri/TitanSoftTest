package titansoft.android.tes.menu.balance

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class BalanceModel : Serializable {

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("status")
    @Expose
    var status: Int = 0

    @SerializedName("traceId")
    @Expose
    var traceId: String? =null


}
