package com.jac.studentregistration.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jac
 * @date 2019-03-29 13:46
 */
@Entity
@Table(name = "student_course", schema = "studentregistration", catalog = "")
@IdClass(StudentCoursePK.class)
public class StudentCourse {
    private String studentId;
    private String courseId;
    private Integer score;
    private String status;

    @Id
    @Column(name = "student_id", nullable = false, length = 64)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "course_id", nullable = false, length = 64)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(score, that.score) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, courseId, score, status);
    }
}
