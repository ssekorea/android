package com.ssekorea.sse.sseproject.main.lecture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ssekorea.sse.sseproject.base.BaseViewHolder;
import com.ssekorea.sse.sseproject.databinding.ItemLectureViewBinding;
import com.ssekorea.sse.sseproject.domain.lecture.Lecture;

import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Lecture> lectureList;

    public LectureAdapter(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemLectureViewBinding itemLectureViewBinding = ItemLectureViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup,false);
        return new LectureViewHolder(itemLectureViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        if (lectureList != null && lectureList.size() > 0) {
            return lectureList.size();
        } else {
            return 0;
        }
    }
    public void addItems(List<Lecture> lectureList){
        this.lectureList.addAll(lectureList);
        notifyDataSetChanged();
    }
    public void clearItems() {
        lectureList.clear();
    }

    public class LectureViewHolder extends BaseViewHolder implements LectureItemViewModel.LectureItemViewModelListener {
        private ItemLectureViewBinding binding;
        private LectureItemViewModel lectureItemViewModel;
        public LectureViewHolder(ItemLectureViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            Lecture lecture = lectureList.get(position);
            lectureItemViewModel= new LectureItemViewModel(lecture, this);
            binding.setViewModel(lectureItemViewModel);
            binding.executePendingBindings();
        }

        @Override
        public void onMoreClick(String itemId) {
            Toast.makeText(itemView.getContext(), "item clicked! :"+itemId, Toast.LENGTH_SHORT).show();

            // todo itemView.getContext().startActivity(new Intent(itemView.getContext(),LectureDetailActivity.class));

        }
    }
}
