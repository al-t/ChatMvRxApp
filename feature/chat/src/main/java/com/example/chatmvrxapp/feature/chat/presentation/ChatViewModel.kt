package com.example.chatmvrxapp.feature.chat.presentation

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.chatmvrxapp.feature.chat.data.ChatState
import com.example.chatmvrxapp.presentation.BaseViewModel
import com.example.chatmvrxapp.router.Router
import org.koin.android.ext.android.inject

class ChatViewModel(
    initialState: ChatState,
    private val router: Router
) : BaseViewModel<ChatState>(initialState) {

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

    companion object :
        MvRxViewModelFactory<ChatViewModel, ChatState> {

        override fun create(viewModelContext: ViewModelContext, state: ChatState): ChatViewModel {
            val router: Router by viewModelContext.activity.inject()
            return ChatViewModel(state, router)
        }

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