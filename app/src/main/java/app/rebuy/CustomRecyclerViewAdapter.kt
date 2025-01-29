import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.rebuy.New_Arrivals_Item_Model
import app.rebuy.R

class CustomRecyclerViewAdapter(private val list: List<New_Arrivals_Item_Model>) :
    RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>() {

    // ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val year: TextView = itemView.findViewById(R.id.year)
        val category: TextView = itemView.findViewById(R.id.category)
        val price: TextView = itemView.findViewById(R.id.price)
    }

    // onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_arrivals_item_layout, parent, false)
        return ViewHolder(view)
    }

    // onBindViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.image.setImageResource(item.Image)
        holder.title.text = item.title
        holder.year.text = item.year.toString()
        holder.category.text = item.category.toString()
        holder.price.text = item.price.toString()
    }

    // Returns the total number of items
    override fun getItemCount(): Int {
        return list.size
    }
}
