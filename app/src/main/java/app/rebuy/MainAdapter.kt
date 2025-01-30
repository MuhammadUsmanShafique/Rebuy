import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.rebuy.DataItem
import app.rebuy.R

class MainAdapter (val section :List<DataItem>):RecyclerView.Adapter<MainAdapter.SectionViewHolder>()
{

    // ViewHolder for the parent RecyclerView
    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sectionTitle: TextView = itemView.findViewById(R.id.section_title)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.child_rec)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.section_layout,parent,false)
return SectionViewHolder(view)
    }

    override fun getItemCount(): Int {
 return section.count()
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
val section = section[position]
holder.sectionTitle.text = section.secTitle

val childAdapter = CustomRecyclerViewAdapter(section.items)
        holder.childRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.childRecyclerView.adapter = childAdapter
    }
}