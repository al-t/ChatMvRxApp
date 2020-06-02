package com.example.chatmvrxapp.feature.chat.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.example.chatmvrxapp.chat.R

class ChatFeedFragment : BaseMvRxFragment(R.layout.fragment_chat_feed) {

    private var feedRecyclerView: RecyclerView? = null
    private val feedAdapter: FeedAdapter by lazy { FeedAdapter() }

    private val viewModel: ChatViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedRecyclerView = view.findViewById(R.id.feedRecyclerView)
        feedRecyclerView?.adapter = feedAdapter
    }

    override fun onDestroyView() {
        feedRecyclerView?.adapter = null
        feedRecyclerView = null
        super.onDestroyView()
    }

    override fun invalidate() = withState(viewModel) { state ->
        feedAdapter.showMessages(state.feedState.messages)
    }
}