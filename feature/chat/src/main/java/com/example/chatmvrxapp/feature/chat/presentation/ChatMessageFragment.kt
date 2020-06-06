package com.example.chatmvrxapp.feature.chat.presentation

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.example.chatmvrxapp.chat.R

internal class ChatMessageFragment : BaseMvRxFragment(R.layout.fragment_chat_message) {

    private var messageInput: EditText? = null
    private var sendButton: View? = null

    private val viewModel: ChatViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageInput = view.findViewById(R.id.messageEditText)
        sendButton = view.findViewById(R.id.sendImageView)
        sendButton?.setOnClickListener {
            viewModel.sendMessage(messageInput?.text.toString())
        }
        messageInput?.addTextChangedListener {
            sendButton?.isEnabled = it?.isNotBlank() == true
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        messageInput!!.setText(state.editMessageState.message)
    }
}