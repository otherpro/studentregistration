package com.jac.studentregistration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jac
 * @date 2019-04-10 19:52
 */
@Entity
@Table(name = "course_select", schema = "studentregistration", catalog = "")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class CourseSelect {
    private String courseSelectId;
    private Integer maxNum;
    private Integer leftNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    private Date endTime;
    private String courseId;
    private String academyId;
    private String teacherId;
    private String teacherName;
    private String cno;
    private String courseName;
    private String grade;
    private Integer credit;
    private String room;
    private String lesson;
    private String week;
    private String status;

    @Id
    @Column(name = "course_select_id", nullable = false, length = 64)
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    public String getCourseSelectId() {
        return courseSelectId;
    }

    public void setCourseSelectId(String courseSelectId) {
        this.courseSelectId = courseSelectId;
    }

    @Basic
    @Column(name = "max_num", nullable = false)
    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    @Basic
    @Column(name = "left_num", nullable = false)
    public Integer getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(Integer leftNum) {
        this.leftNum = leftNum;
    }

    @Basic
    @Column(name = "start_time", nullable = false)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = false)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "course_id", nullable = false, length = 64)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "academy_id", nullable = false, length = 64)
    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    @Basic
    @Column(name = "teacher_id", nullable = false, length = 64)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacher_name", nullable = false, length = 100)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "cno", nullable = false, length = 64)
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Basic
    @Column(name = "course_name", nullable = false, length = 100)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "grade", nullable = false, length = 64)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "credit", nullable = false)
    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "room", nullable = false, length = 64)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Basic
    @Column(name = "lesson", nullable = false, length = 64)
    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Basic
    @Column(name = "week", nullable = false, length = 64)
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSelect that = (CourseSelect) o;
        return Objects.equals(courseSelectId, that.courseSelectId) &&
                Objects.equals(maxNum, that.maxNum) &&
                Objects.equals(leftNum, that.leftNum) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(academyId, that.academyId) &&
                Objects.equals(teacherId, that.teacherId) &&
                Objects.equals(teacherName, that.teacherName) &&
                Objects.equals(cno, that.cno) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(credit, that.credit) &&
                Objects.equals(room, that.room) &&
                Objects.equals(lesson, that.lesson) &&
                Objects.equals(week, that.week) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseSelectId, maxNum, leftNum, startTime, endTime, courseId, academyId, teacherId, teacherName, cno, courseName, grade, credit, room, lesson, week, status);
    }
}
