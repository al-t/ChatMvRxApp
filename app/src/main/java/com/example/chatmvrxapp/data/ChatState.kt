package com.example.chatmvrxapp.data

import com.airbnb.mvrx.MvRxState

data class ChatState(
    val headerState: HeaderState = HeaderState("Чад кутежа", 3),
    val feedState: FeedState = FeedState(
        listOf(
            Message(
                true,
                "Привет!"
            ),
            Message(
                false,
                "Привет!"
            ),
            Message(
                true,
                "Как дела?"
            )
        )
    ),
    val messageState: MessageState = MessageState("Отлич")
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


