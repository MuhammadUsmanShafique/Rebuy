package app.rebuy

import SecondAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyOrdersFrag: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_orders, container, false)

        // Create the list of liked items
        val list = listOf(
            liked_order_listings_model(R.drawable.liked_item1, "Apple AirPods Pro", "21 Jan 2021", 8999),
            liked_order_listings_model(R.drawable.product_thumbnail_two, "Moby Dick", "Adventure", 15),
            liked_order_listings_model(R.drawable.liked_item1, "Apple AirPods Pro", "21 Jan 2021", 8999),
            liked_order_listings_model(R.drawable.product_thumbnail, "Batman Toy", "21 jan 2018", 899)
        )
        val back = view.findViewById<ImageView>(R.id.back)
        val navToSidebar = view.findViewById<ImageView>(R.id.sidebar)
        // Initialize the RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.liked_rec)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set the adapter to RecyclerView
        val adapter = SecondAdapter(list,true)
        recyclerView.adapter = adapter

        val navController = requireActivity().findNavController(R.id.sidebar_fragment_container)
        back.setOnClickListener {
           requireActivity().finish()
        }
        navToSidebar.setOnClickListener{
            navController.navigate(R.id.action_myOrders_to_sidebarFrag)
        }


        return view
    }
}
