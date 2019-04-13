package com.jac.studentregistration.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Jac
 * @date 2019-03-29 13:46
 */
@Entity
public class Teacher {
    private String teacherId;
    private String academyId;
    private String tno;
    private String teacherName;
    private String phone;
    private String email;
    private String pw;
    private String status;
    private String remarks;

    @Id
    @Column(name = "teacher_id", nullable = false, length = 64)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
    @Column(name = "tno", nullable = false, length = 64)
    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
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
    @Column(name = "phone", nullable = true, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 300)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pw", nullable = false, length = 64)
    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
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
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherId, teacher.teacherId) &&
                Objects.equals(academyId, teacher.academyId) &&
                Objects.equals(tno, teacher.tno) &&
                Objects.equals(teacherName, teacher.teacherName) &&
                Objects.equals(phone, teacher.phone) &&
                Objects.equals(email, teacher.email) &&
                Objects.equals(pw, teacher.pw) &&
                Objects.equals(status, teacher.status) &&
                Objects.equals(remarks, teacher.remarks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teacherId, academyId, tno, teacherName, phone, email, pw, status, remarks);
    }
}
