package app.rebuy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController

class SidebarFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sidebar, container, false)

        val navToMyOrders = view.findViewById<LinearLayout>(R.id.myorder)
        val closeSidebar = view.findViewById<ImageView>(R.id.close_sidebar)
        val signOutBtn = view.findViewById<AppCompatButton>(R.id.sign_out_btn)
        val navController = requireActivity().findNavController(R.id.sidebar_fragment_container)
        signOutBtn.setOnClickListener {
            startActivity(Intent(requireContext(), Login::class.java)) // Use requireContext() instead of 'this'
        }

        closeSidebar.setOnClickListener {
            requireActivity().finish()
        }

        navToMyOrders.setOnClickListener {
            navController.navigate(R.id.action_sidebarFrag_to_myOrders)

        }

        return view
    }
}
