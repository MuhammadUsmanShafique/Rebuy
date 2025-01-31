import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.rebuy.R
import app.rebuy.liked_order_listings_model

class SecondAdapter(
    private val list: List<liked_order_listings_model>,
    private val isMyOrder:Boolean ? = null
) :
    RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    // ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val date: TextView = itemView.findViewById(R.id.date)
        val price: TextView = itemView.findViewById(R.id.price)
        val heartImage : ImageView = itemView.findViewById(R.id.heart_image)
        val rateNow : TextView = itemView.findViewById(R.id.rate_noew_text)
    }

    // onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_for_liked_my_orders_items, parent, false)
        return ViewHolder(view)
    }

    // onBindViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.date.text = item.data
        holder.price.text = "₹ ${item.price}"
        if(isMyOrder==null ){
            holder.rateNow.visibility = View.GONE
        }
        else
        {

            holder.heartImage.visibility = View.GONE
        }


    }

    // Returns the total number of items
    override fun getItemCount(): Int {
        return list.size
    }
}
