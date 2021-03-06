package com.example.chatmvrxapp.feature.chat.presentation

import com.airbnb.mvrx.ViewModelContext
import com.example.chatmvrxapp.di.AssistedViewModelFactory
import com.example.chatmvrxapp.di.DaggerMvRxViewModelFactory
import com.example.chatmvrxapp.feature.chat.data.ChatState
import com.example.chatmvrxapp.presentation.BaseViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class ChatViewModel @AssistedInject constructor(
    @Assisted state: ChatState
) : BaseViewModel<ChatState>(state) {

    fun sendMessage(message: String) = setState {
        copy(
            headerState = headerState.copy(messageCount = headerState.messageCount + 1),
            feedState = ChatState.FeedState(feedState.messages.toMutableList()
                .also {
                    it.add(ChatState.Message(false, message))
                }),
            editMessageState = ChatState.EditMessageState("")
        )
    }

    @AssistedInject.Factory
    interface Factory :
        AssistedViewModelFactory<ChatViewModel, ChatState> {
        override fun create(state: ChatState): ChatViewModel
    }

    companion object :
        DaggerMvRxViewModelFactory<ChatViewModel, ChatState>(
            ChatViewModel::class.java
        ) {

        override fun initialState(viewModelContext: ViewModelContext): ChatState? {
            return ChatState(
                headerState = ChatState.HeaderState(
                    "Чад кутежа",
                    3
                ),
                feedState = ChatState.FeedState(
                    listOf(
                        ChatState.Message(
                            true,
                            "Привет!"
                        ),
                        ChatState.Message(
                            false,
                            "Привет!"
                        ),
                        ChatState.Message(
                            true,
                            "Как дела?"
                        )
                    )
                ),
                editMessageState = ChatState.EditMessageState("Отлич")
            )
        }
    }
}