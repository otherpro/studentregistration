package com.jac.studentregistration.dao;


import com.jac.studentregistration.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */

public interface CourseDao extends JpaRepository<Course, String> {
    @Query(value = "select DISTINCT  c.max_num, c.course_id, c.academy_id,c.teacher_id, c.cno ,c.course_name, c.grade ,c.credit, c.room , c.lesson ,c.week, c.status ,c.remarks from student_course sc , course c where sc.course_id=c.course_id and sc.student_id=?1 and c.status='0' order by c.lesson", nativeQuery = true)
    List<Course> listByStuIdAndSortByLesson(String studentId);

    @Query(value = "select DISTINCT  c.max_num, c.course_id, c.academy_id,c.teacher_id, c.cno ,c.course_name, c.grade ,c.credit, c.room , c.lesson ,c.week, c.status ,c.remarks from student_course sc , course c  where sc.course_id=c.course_id and sc.student_id=?1 and c.grade=?2 order by c.lesson", nativeQuery = true)
    List<Course> listByStuIdAndGrade(String studentId, String grade);
}
