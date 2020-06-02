package com.example.chatmvrxapp.feature.chat.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.example.chatmvrxapp.chat.R

class ChatInfoFragment : BaseMvRxFragment(R.layout.frament_chat_info) {

    private var title: TextView? = null
    private var messagesCount: TextView? = null

    private val viewModel: ChatViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        title = view.findViewById(R.id.chatNameTextView)
        messagesCount = view.findViewById(R.id.messageCountTextView)
    }

    override fun onDestroyView() {
        title = null
        messagesCount = null
        super.onDestroyView()
    }

    override fun invalidate() = withState(viewModel) { state ->
        title?.text = state.headerState.chatName
        messagesCount?.text = String.format("%s messages", state.headerState.messageCount)
    }

}