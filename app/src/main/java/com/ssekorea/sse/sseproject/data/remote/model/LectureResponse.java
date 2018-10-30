package com.ssekorea.sse.sseproject.data.remote.model;

import com.ssekorea.sse.sseproject.domain.lecture.Lecture;

import java.util.List;

public class LectureResponse {
    public String statusCode;
    public class GetLectureLists extends LectureResponse{
        public List<Lecture> lectureList;
    }
}
