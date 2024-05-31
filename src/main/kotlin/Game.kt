import com.google.gson.annotations.SerializedName

class Game(
    val title: String,
    val thumb: String
) {
    val description  = ""
    override fun toString(): String {
        return "Game(title='$title', thumb='$thumb', description='$description')"
    }


}