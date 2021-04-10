package com.example.firestrore_data_insert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {

            var name:String=name.text.toString()
            var marks:Int=marks.text.toString().toInt()

val db=FirebaseFirestore.getInstance()

            val user:MutableMap<String, Any> =HashMap()
            user["name"]=name
            user["marks"]=marks
            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this,"Data insert successfully",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                }
        }
    }
}