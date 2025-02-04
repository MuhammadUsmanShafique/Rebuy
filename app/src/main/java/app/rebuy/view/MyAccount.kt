package app.rebuy.view

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.rebuy.R

class MyAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)
        val address = findViewById<EditText>(R.id.address)

        val nameEdit = findViewById<ImageView>(R.id.name_edit)
        val emailEdit = findViewById<ImageView>(R.id.email_edit)
        val phoneEdit = findViewById<ImageView>(R.id.phone_edit)
        val addressEdit = findViewById<ImageView>(R.id.address_edit)
        val closeAccountSetting = findViewById<ImageView>(R.id.close_account_setting)

fun makeEditable(editText:EditText){
    val isEditable = editText.isFocusable
    if (!isEditable) {
        // Make EditText editable
        editText.isFocusable = true
        editText.isFocusableInTouchMode = true
        editText.isCursorVisible = true
        editText.requestFocus()
        editText.setSelection(editText.text.length) // Move cursor to the end
    }
    else{
        editText.isFocusable = false
        editText.isFocusableInTouchMode = false
        editText.isCursorVisible = false
    }
}

        nameEdit.setOnClickListener{
makeEditable(name)
        }
        emailEdit.setOnClickListener{
            makeEditable(email)
        }
        phoneEdit.setOnClickListener{
            makeEditable(phone)
        }
        addressEdit.setOnClickListener{
            makeEditable(address)
        }
        closeAccountSetting.setOnClickListener{
finish()

        }












    }
}