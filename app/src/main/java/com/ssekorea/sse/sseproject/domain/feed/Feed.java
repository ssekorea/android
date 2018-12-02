package com.ssekorea.sse.sseproject.domain.feed;

import java.util.List;

public class Feed {
    private int id;
    private String title;
    private String contetns;
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

    public String getContetns() {
        return contetns;
    }

    public void setContetns(String contetns) {
        this.contetns = contetns;
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
