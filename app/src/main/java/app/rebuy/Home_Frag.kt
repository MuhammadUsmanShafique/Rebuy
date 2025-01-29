package app.rebuy

import CustomRecyclerViewAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home_Frag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
val openSidebar = view.findViewById<ImageView>(R.id.sidebar_icon)
val searchText = view.findViewById<EditText>(R.id.search_text)
val searchSec = view.findViewById<LinearLayout>(R.id.search)
val navToMyAccount = view.findViewById<androidx.appcompat.widget.AppCompatImageView>(R.id.nav_to_my_account)
navToMyAccount.setOnClickListener{
    startActivity(Intent(requireContext(), MyAccount::class.java,))
}

// showing cursor on which anywhere inside the linear layout
searchSec.setOnClickListener{
    val isEditable = searchText.isFocusable
        searchText.isFocusable = true
        searchText.isFocusableInTouchMode = true
        searchText.isCursorVisible = true
        searchText.requestFocus()
}




openSidebar.setOnClickListener{

    startActivity(Intent(requireContext(), Sidebar::class.java,))


}


 val recyclerView = view.findViewById<RecyclerView>(R.id.new_arrivals_list)
 recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false,)


        val list = listOf(
            New_Arrivals_Item_Model(R.drawable.product_thumbnail, "The Great Gatsby", 1925, "Fiction", 10),
            New_Arrivals_Item_Model(R.drawable.setting_icon, "Moby Dick", 1851, "Adventure", 15),
            New_Arrivals_Item_Model(R.drawable.setting_icon, "1984", 1949, "Dystopian", 12),
            New_Arrivals_Item_Model(R.drawable.setting_icon, "Hamlet", 1603, "Drama", 20)
        )


val adapter =CustomRecyclerViewAdapter(list)
recyclerView.adapter = adapter

    }



}