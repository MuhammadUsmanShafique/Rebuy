package app.rebuy.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.rebuy.R
import app.rebuy.viewmodel.MemesViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestScreenForApi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_screen_for_api)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val memesText = findViewById<TextView>(R.id.meme)
        val fetchMemeBtn = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.fet_meme_btn)
        val memeViewModel : MemesViewModel by viewModels()



        fetchMemeBtn.setOnClickListener {
            memeViewModel.getMemesData()
            memeViewModel.memes.observe(this, { memes ->
                memesText.setText(memes.data.memes[0].name.toString())
            })
        }





    }
}