package com.ssekorea.sse.sseproject.main.feed;

import android.arch.lifecycle.MutableLiveData;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.feed.Feed;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import java.util.List;

public class FeedViewModel extends BaseViewModel<FeedNavigator> {
    private final ApiHelper apiHelper;
    private final MutableLiveData<List<Feed>> feedListLiveData;

    public FeedViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper) {
        super(mSchedulerProvider);
        this.apiHelper = apiHelper;
        this.feedListLiveData = new MutableLiveData<>();
        fetchFeeds();
    }

    public void fetchFeeds() {
        setIsLoading(true);
        getCompositeDisposable().add(apiHelper.getFeedList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    if (response.feedList != null)
                        getFeedListLiveData().setValue(response.feedList);
                }, throwable -> {
                    setIsLoading(false);
                    getUiHandleError().setValue(throwable);
                }));
    }

    public MutableLiveData<List<Feed>> getFeedListLiveData() {
        return feedListLiveData;
    }
}
