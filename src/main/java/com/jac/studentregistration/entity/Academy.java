package com.jac.studentregistration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jac
 * @date 2019-04-08 23:30
 */
@Entity
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Academy {
    private String academyId;
    private String academyName;
    private String className;
    private String status;

    @Id
    @Column(name = "academy_id", nullable = false, length = 64)
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    @Basic
    @Column(name = "academy_name", nullable = false, length = 64)
    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    @Basic
    @Column(name = "class_Name", nullable = false, length = 64)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
        Academy academy = (Academy) o;
        return Objects.equals(academyId, academy.academyId) &&
                Objects.equals(academyName, academy.academyName) &&
                Objects.equals(className, academy.className) &&
                Objects.equals(status, academy.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(academyId, academyName, className, status);
    }
}
