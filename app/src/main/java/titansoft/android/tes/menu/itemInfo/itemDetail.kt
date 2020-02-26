package titansoft.android.tes.menu.itemInfo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class itemDetail : Serializable {

    @SerializedName("moreDescription")
    @Expose
    var moreDescription : String? = null

    @SerializedName("maximum")
    @Expose
    var maximum: Int = 0

    @SerializedName("minimum")
    @Expose
    var minimum: Int = 0
}
