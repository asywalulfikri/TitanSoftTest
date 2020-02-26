package titansoft.android.tes.menu.player

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PlayerModel : Serializable {

    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("ranking")
    @Expose
    var ranking: Int = 0


}
