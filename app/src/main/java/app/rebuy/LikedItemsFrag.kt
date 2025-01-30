package app.rebuy

import SecondAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LikedItemsFrag : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_liked_items, container, false)

        // Create the list of liked items
        val list = listOf(
            liked_order_listings_model(R.drawable.product_thumbnail, "Batman Toy", "Funskool", 899),
            liked_order_listings_model(R.drawable.product_thumbnail, "Moby Dick", "Adventure", 15),
            liked_order_listings_model(R.drawable.product_thumbnail_two, "1984", "Dystopian", 12),
            liked_order_listings_model(R.drawable.product_thumbnail, "Hamlet", "Drama", 20)
        )

        // Initialize the RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.liked_rec)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set the adapter to RecyclerView
        val adapter = SecondAdapter(list)
        recyclerView.adapter = adapter

        return view
    }
}
