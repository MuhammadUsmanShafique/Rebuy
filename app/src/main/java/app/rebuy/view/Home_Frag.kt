package app.rebuy.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.rebuy.R
import app.rebuy.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        searchText.isFocusable = true
        searchText.isFocusableInTouchMode = true
        searchText.isCursorVisible = true
        searchText.requestFocus()
}




openSidebar.setOnClickListener{

    startActivity(Intent(requireContext(), Sidebar::class.java,))


}


val recyclerView = view.findViewById<RecyclerView>(R.id.parent_rec)
 recyclerView.layoutManager = LinearLayoutManager(requireContext())

     val homeViewModel: HomeViewModel by viewModels()

        homeViewModel.loadData()
homeViewModel.getAllSectionsData.observe(viewLifecycleOwner,
    { allSectionsData->
        val adapter = MainAdapter(allSectionsData)
        recyclerView.adapter = adapter

    }
)













    }



}