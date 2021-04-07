package com.mulugetaewnu.room


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDatabase
    private lateinit var userDao: UserDao
    private lateinit var addbutton: Button
    private  lateinit var fname:EditText
    private lateinit var lname:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            appDatabase = AppDatabase.getDatabase(this)
            userDao = appDatabase.userDao()

        addbutton = button
        fname = editTextTextPersonName
        lname = editTextTextPersonName2
        addbutton.setOnClickListener {
            val user = readFields()
                saveUser(user)

            clearFields()
            Toast.makeText(applicationContext, "succses", Toast.LENGTH_SHORT).show()

        }



    }
        private fun readFields() = User(
            1,
            fname.text.toString(),
            lname.text.toString()

            )

        private fun clearFields() {
            fname.setText("")
            lname.setText("")

        }


        private fun saveUser(user: User){
            userDao.insertAll(user)
        }




}