package com.ssekorea.sse.sseproject.domain.lecture;

import java.util.ArrayList;
import java.util.List;

public class AppLectureRepository implements LectureRepository {
    private List<Lecture> lectureList;

    public AppLectureRepository(){
        lectureList = new ArrayList<>();
    }

    public List<Lecture> getLectureList(){
        return this.lectureList;
    }

    public void setLectureList(List<Lecture> lectureList){
        this.lectureList = lectureList;
    }

    public void addLectureList(List<Lecture> lectureList){
        this.lectureList.addAll(lectureList);
    }

    public void addLecture(Lecture lecture){
        this.lectureList.add(lecture);
    }

    public void clear(){
        this.lectureList.clear();
    }

}
