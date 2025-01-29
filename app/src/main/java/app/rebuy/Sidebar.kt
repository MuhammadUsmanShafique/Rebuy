package app.rebuy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sidebar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sidebar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val closeSidebar = findViewById<ImageView>(R.id.close_sidebar)
        val signOutBtn =  findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.sign_out_btn)
        signOutBtn.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
        closeSidebar.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}