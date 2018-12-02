package com.ssekorea.sse.sseproject.data.remote.model;

import com.ssekorea.sse.sseproject.domain.feed.Feed;

import java.util.List;

public class FeedResponse {
    public String statusCode;
    public class GetFeedList extends ShopResponse{
        public List<Feed> feedList;
    }
}
