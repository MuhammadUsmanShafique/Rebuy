package app.rebuy
import android.provider.ContactsContract.RawContacts.Data
data class liked_order_listings_model(
    val image:Int,
    val title:String,
    val data: String,
    val price:Int,
)
