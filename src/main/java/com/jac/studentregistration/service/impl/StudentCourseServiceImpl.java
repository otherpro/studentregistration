package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.CourseDao;
import com.jac.studentregistration.dao.StudentCourseDao;
import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.entity.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */
@Service
public class StudentCourseServiceImpl {
    @Autowired
    public StudentCourseDao studentCourseDao;
    @Autowired
    public CourseDao courseDao;

    //查看所有学院
    public StudentCourse save(StudentCourse studentCourse) {
        return studentCourseDao.save(studentCourse);
    }

    public void delete(String id) {
        studentCourseDao.deleteById(id);
    }

    public StudentCourse get(String id) {
        return studentCourseDao.getOne(id);
    }

    //根据学生id 获取当前学期课程 课程标志位选择正在教授的课程 按照lesson进行显示
    public List<Course> listByStuIdAndSortByLesson(String studentId) {
        return courseDao.listByStuIdAndSortByLesson(studentId);
    }

    public List<Course> listByStuIdAndGrade(String studentId, String grade) {
        return courseDao.listByStuIdAndGrade(studentId, grade);
    }

    /**
     * 获取所有学院信息 列表 之后进行二项选择专业班级
     *
     * @return
     */
    public List<StudentCourse> listAll() {
        return studentCourseDao.findAll();
    }

    public List<StudentCourse> findAll(StudentCourse studentCourse) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("academyName", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("className", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("academyId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<StudentCourse> example = Example.of(studentCourse, matcher);
        return studentCourseDao.findAll(example);
    }

    public Page<StudentCourse> findAll(StudentCourse studentCourse, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("academyName", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("className", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("academyId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<StudentCourse> example = Example.of(studentCourse, matcher);
        return studentCourseDao.findAll(example, pageable);
    }
}
