package com.ssekorea.sse.sseproject.main.lecture;

import android.databinding.ObservableField;

import com.ssekorea.sse.sseproject.domain.lecture.Lecture;

public class LectureItemViewModel {
    public final ObservableField<String> title;
    public final ObservableField<String> userNumInfo;
    public final ObservableField<String> address;
    public final ObservableField<String> timeInfo;
    private final Lecture lecture;
    private final LectureItemViewModelListener listener;

    public LectureItemViewModel(Lecture lecture,LectureItemViewModelListener listener) {
        this.lecture = lecture;
        this.listener = listener;
        this.title = new ObservableField<>(lecture.getTitle());
        this.userNumInfo = new ObservableField<>(getNumInfo(lecture.getCurStudentNum(),lecture.getMaxStudentNum()));
        this.address = new ObservableField<>(getAddressString(lecture.getAddress1(),lecture.getAddress2(),lecture.getAddress3()));
        this.timeInfo = new ObservableField<>(getTimeString(lecture.getStartTime(),lecture.getEndTime()));
    }


    public void onMoreButtonClick(){
        listener.onMoreClick(lecture.getLectureId());
    }

    public interface LectureItemViewModelListener{
        void onMoreClick(String itemId);
    }

    private String getAddressString(String address1,String address2,String address3){
        return address1+address2+"\n"+address3;
    }

    private String getNumInfo(int curNum, int maxNum){
        return ""+curNum+" / "+maxNum;

    }

    private String getTimeString(String startTime, String endTime) {
        return startTime+"~"+endTime;
    }
}
