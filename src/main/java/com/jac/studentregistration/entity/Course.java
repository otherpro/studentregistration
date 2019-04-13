package com.jac.studentregistration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jac
 * @date 2019-04-10 19:52
 */
@Entity
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Course {
    private Integer maxNum;
    private String courseId;
    private String academyId;
    private String teacherId;
    private String cno;
    private String courseName;
    private String grade;
    private Integer credit;
    private String room;
    private String lesson;
    private String week;
    private String status;
    private String remarks;

    @Basic
    @Column(name = "max_num", nullable = false)
    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    @Id
    @Column(name = "course_id", nullable = false, length = 64)
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
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

    @Basic
    @Column(name = "remarks", nullable = true, length = 500)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(maxNum, course.maxNum) &&
                Objects.equals(courseId, course.courseId) &&
                Objects.equals(academyId, course.academyId) &&
                Objects.equals(teacherId, course.teacherId) &&
                Objects.equals(cno, course.cno) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(grade, course.grade) &&
                Objects.equals(credit, course.credit) &&
                Objects.equals(room, course.room) &&
                Objects.equals(lesson, course.lesson) &&
                Objects.equals(week, course.week) &&
                Objects.equals(status, course.status) &&
                Objects.equals(remarks, course.remarks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(maxNum, courseId, academyId, teacherId, cno, courseName, grade, credit, room, lesson, week, status, remarks);
    }
}
