package titansoft.android.tes.menu.itemInfo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class ItemInfoModel : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("value")
    @Expose
    var value: Int = 0


    @SerializedName("itemDetail")
    @Expose
    var itemDetail = itemDetail()

}
