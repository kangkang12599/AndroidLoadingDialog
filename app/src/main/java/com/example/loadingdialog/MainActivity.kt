package com.example.loadingdialog

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            this.lifecycleScope.launch {
                showDialog()
            }
        }
    }

    private suspend fun showDialog(){
        val loadingDialog = LoadingDialog(this)
        loadingDialog.displayDialog()

        withContext(Dispatchers.IO){
            Thread.sleep(5000)
            loadingDialog.dismissDialog()
        }
    }
}