package com.jac.studentregistration.dao;


import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */

public interface StudentCourseDao extends JpaRepository<StudentCourse, String> {



}
