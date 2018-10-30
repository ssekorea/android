package com.ssekorea.sse.sseproject.domain.lecture;

import java.util.List;

public interface LectureRepository {
    List<Lecture> getLectureList();
    void setLectureList(List<Lecture> lectureList);
    void addLectureList(List<Lecture> lectureList);
    void addLecture(Lecture lecture);
    void clear();
}
