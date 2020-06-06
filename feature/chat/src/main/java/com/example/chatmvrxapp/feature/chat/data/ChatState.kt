package com.example.chatmvrxapp.feature.chat.data

import com.airbnb.mvrx.MvRxState

/**
 * Состояние вьюмодели чата
 *
 * @property headerState состояние заголовка
 * @property feedState состояние ленты сообщений
 * @property editMessageState состояние редактора сообщения
 */
data class ChatState(
    val headerState: HeaderState,
    val feedState: FeedState,
    val editMessageState: EditMessageState
) : MvRxState {

    /**
     * Состояние заголовка чата
     *
     * @property chatName названиие чата
     * @property messageCount количество сообщений
     */
    data class HeaderState(
        val chatName: String,
        val messageCount: Int
    )

    /**
     * Состояние ленты сообщений
     *
     * @property messages список сообщений
     */
    data class FeedState(
        val messages: List<Message>
    )

    /**
     * Состояние редактора сообщения
     *
     * @property message введённый текст сообщения
     */
    data class EditMessageState(
        val message: String
    )

    /**
     * Сообщение
     *
     * @property isIncoming признак входящего сообщеня
     * @property text текст сообщения
     */
    data class Message(
        val isIncoming: Boolean,
        val text: String
    )
}


