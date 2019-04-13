package com.jac.studentregistration.dao;


import com.jac.studentregistration.entity.Academy;
import com.jac.studentregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */
public interface StudentDao extends JpaRepository<Student, String> {
}
