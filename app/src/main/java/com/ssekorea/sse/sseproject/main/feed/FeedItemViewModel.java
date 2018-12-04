package com.ssekorea.sse.sseproject.main.feed;

import android.databinding.ObservableField;

import com.ssekorea.sse.sseproject.domain.feed.Feed;

public class FeedItemViewModel {
    public final ObservableField<String> title;
    public final ObservableField<String> desc;

    private final Feed feed;

    public FeedItemViewModel(Feed feed){
        this.feed = feed;
        title = new ObservableField<>(feed.getTitle());
        desc = new ObservableField<>(feed.getContents());

    }
}
