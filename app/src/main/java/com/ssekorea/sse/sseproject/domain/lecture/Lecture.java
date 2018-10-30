package com.ssekorea.sse.sseproject.domain.lecture;


import com.google.gson.annotations.SerializedName;

public class Lecture {
    @SerializedName("id")
    String lectureId = "";
    @SerializedName("title")
    String title;
    @SerializedName("startTime")
    String startTime;
    @SerializedName("endTime")
    String endTime;
    @SerializedName("placeAddress1")
    String address1;
    @SerializedName("placeAddress2")
    String address2;
    @SerializedName("placeAddress3")
    String address3;

    @SerializedName("maxStudentNum")
    int maxStudentNum;
    int curStudentNum = 0;
    @SerializedName("explanation")
    String explain;
    @SerializedName("lectureType")
    String lectureType;
    @SerializedName("maxTeacherNum")
    int maxTeacherNum;
    int curTeacherNum = 0;


    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public int getMaxStudentNum() {
        return maxStudentNum;
    }

    public void setMaxStudentNum(int maxStudentNum) {
        this.maxStudentNum = maxStudentNum;
    }

    public int getCurStudentNum() {
        return curStudentNum;
    }

    public void setCurStudentNum(int curStudentNum) {
        this.curStudentNum = curStudentNum;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getLectureType() {
        return lectureType;
    }

    public void setLectureType(String lectureType) {
        this.lectureType = lectureType;
    }

    public int getMaxTeacherNum() {
        return maxTeacherNum;
    }

    public void setMaxTeacherNum(int maxTeacherNum) {
        this.maxTeacherNum = maxTeacherNum;
    }

    public int getCurTeacherNum() {
        return curTeacherNum;
    }

    public void setCurTeacherNum(int curTeacherNum) {
        this.curTeacherNum = curTeacherNum;
    }
}
