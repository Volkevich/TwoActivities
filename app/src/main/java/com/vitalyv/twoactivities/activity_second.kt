package com.vitalyv.twoactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vitalyv.twoactivities.databinding.ActivitySecondBinding


const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
class activity_second : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val messageExtra = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = binding.messageIdSecond
        textView.text = messageExtra
    }

    fun returnReply(view: View) {
        val reply = binding.messageTextIdSecond.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}




