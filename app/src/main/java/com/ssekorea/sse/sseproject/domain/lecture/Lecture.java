package com.ssekorea.sse.sseproject.domain.lecture;


public class Lecture {
    private String lectureId;
    private String title;
    private String startTime;
    private String endTime;
    private String address1;
    private String address2;
    private String address3;

    private int maxStudentNum;
    private int curStudentNum;
    private String explain;
    private String lectureType;
    private int maxTeacherNum;
    private int curTeacherNum;


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
