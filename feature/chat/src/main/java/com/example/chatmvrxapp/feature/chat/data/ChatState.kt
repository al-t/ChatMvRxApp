package com.example.chatmvrxapp.feature.chat.data

import com.airbnb.mvrx.MvRxState

data class ChatState(
    val headerState: HeaderState,
    val feedState: FeedState,
    val messageState: MessageState
) : MvRxState {

    data class HeaderState(
        val chatName: String,
        val messageCount: Int
    )

    data class FeedState(
        val messages: List<Message>
    )

    data class MessageState(
        val message: String
    )

    data class Message(
        val isIncoming: Boolean,
        val text: String
    )
}


