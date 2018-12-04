package com.ssekorea.sse.sseproject.domain.feed;

import java.util.List;

public class Feed {
    private int id;
    private String title;
    private String contents;
    private String registerDate;
    private List<String> feedImageUrls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public List<String> getFeedImageUrls() {
        return feedImageUrls;
    }

    public void setFeedImageUrls(List<String> feedImageUrls) {
        this.feedImageUrls = feedImageUrls;
    }
}
