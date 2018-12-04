package com.ssekorea.sse.sseproject.main.feed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssekorea.sse.sseproject.base.BaseViewHolder;
import com.ssekorea.sse.sseproject.common.GlideApp;
import com.ssekorea.sse.sseproject.databinding.ItemFeedViewBinding;
import com.ssekorea.sse.sseproject.domain.feed.Feed;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Feed> feedList;

    public FeedAdapter(List<Feed> feedList){
        this.feedList=feedList;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemFeedViewBinding itemFeedViewBinding = ItemFeedViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup,false);
        return new FeedViewHolder(itemFeedViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        if (feedList != null && feedList.size() > 0) {
            return feedList.size();
        } else {
            return 0;
        }
    }
    public void addItems(List<Feed> lectureList){
        this.feedList.addAll(lectureList);
        notifyDataSetChanged();
    }
    public void clearItems() {
        feedList.clear();
    }

    public class FeedViewHolder extends BaseViewHolder {
        private ItemFeedViewBinding binding;
        private FeedItemViewModel feedItemViewModel;
        public FeedViewHolder(ItemFeedViewBinding binding){
            super(binding.getRoot());
            this.binding= binding;
        }

        @Override
        public void onBind(int position){
            Feed feed = feedList.get(position);
            feedItemViewModel = new FeedItemViewModel(feed);
            binding.setViewModel(feedItemViewModel);
            binding.executePendingBindings();
            binding.img1.setVisibility(View.INVISIBLE);
            binding.img2.setVisibility(View.INVISIBLE);
            binding.img3.setVisibility(View.INVISIBLE);
            if (feed.getFeedImageUrls().size()>0) {
                GlideApp.with(binding.img1)
                        .load(feed.getFeedImageUrls().get(0))
                        .centerCrop()
                        .into(binding.img1);
                binding.img1.setVisibility(View.VISIBLE);
            }else{
                binding.img1.setVisibility(View.GONE);
                binding.img2.setVisibility(View.GONE);
                binding.img3.setVisibility(View.GONE);
            }
            if (feed.getFeedImageUrls().size()>1) {
                GlideApp.with(binding.img2)
                        .load(feed.getFeedImageUrls().get(1))
                        .centerCrop()
                        .into(binding.img2);
                binding.img2.setVisibility(View.VISIBLE);
            }
            if (feed.getFeedImageUrls().size()>2) {
                GlideApp.with(binding.img3)
                        .load(feed.getFeedImageUrls().get(2))
                        .centerCrop()
                        .into(binding.img3);
                binding.img3.setVisibility(View.VISIBLE);
            }
        }
    }
}
