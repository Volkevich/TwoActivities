package com.vitalyv.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vitalyv.twoactivities.databinding.ActivityMainBinding


const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView
    private val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mReplyHeadTextView = binding.textHeaderReply
        mReplyTextView = binding.textMessageReply

        binding.buttonMain.setOnClickListener {
            launchSecondActivity(binding.root)
        }
    }

    fun launchSecondActivity(view: View) {
        val message = binding.messageTextId.text.toString()
        val intent = Intent(this, activity_second::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)

        Log.d("TAGS", "Button clicked!")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val reply: String? = data?.getStringExtra(EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }
}
