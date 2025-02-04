package app.rebuy.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import app.rebuy.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val reqFromSidebarForLikedItems = intent.getBooleanExtra("navToLikedItemsFrag",false)



        // Function to load fragments
        fun loadFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frag_container, fragment)
                .commit()
        }

        // Load default fragment (that is Home Frag)
        loadFragment(Home_Frag())

        // Set up Bottom Navigation listener
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(Home_Frag())
                    true
                }
                R.id.liked_items -> {
                    loadFragment(LikedItemsFrag())
                    true
                }
                else -> false
            }
        }




        if(reqFromSidebarForLikedItems){
            bottomNavigationView.selectedItemId = R.id.liked_items
        }




    }
}
