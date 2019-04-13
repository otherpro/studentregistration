package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.CourseDao;
import com.jac.studentregistration.dao.CourseSelectDao;
import com.jac.studentregistration.dao.TeacherDao;
import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.entity.CourseSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */
@Service
public class CourseServiceImpl {
    @Autowired
    public CourseDao courseDao;
    @Autowired
    private CourseSelectDao courseSelectDao;
    @Autowired
    private TeacherDao teacherDao;

    /**
     * 添加选课
     * 先添加到默认课程表，之后再获取带有自增uuid的课程填加到秒杀表中
     * 当管理员设定好选课时间 将秒杀表中课程加上开始结束时间
     *
     * @param course
     * @return
     */
    @Transactional
    public Course add(Course course) {

         course=courseDao.save(course);

        CourseSelect courseSelect = new CourseSelect();
        courseSelect.setAcademyId(course.getAcademyId());
        courseSelect.setCourseId(course.getCourseId());
        courseSelect.setTeacherId(course.getTeacherId());
        courseSelect.setCourseName(course.getCourseName());
        courseSelect.setGrade(course.getGrade());
        courseSelect.setWeek(course.getWeek());
        courseSelect.setLesson(course.getLesson());
        courseSelect.setCredit(course.getCredit());
        courseSelect.setCno(course.getCno());
        courseSelect.setRoom(course.getRoom());
        courseSelect.setStatus(course.getStatus());
        courseSelect.setTeacherName(teacherDao.getOne(course.getTeacherId()).getTeacherName());
        courseSelect.setMaxNum(course.getMaxNum());
        courseSelect.setLeftNum(course.getMaxNum());

        courseSelectDao.save(courseSelect);

        return course;

    }

    public void delete(String id) {
        courseDao.deleteById(id);
    }

    public Course update(Course course){
        return courseDao.save(course);
    }

    public Course get(String id) {
        return courseDao.getOne(id);
    }

    /**
     * 获取所有学院信息 列表 之后进行二项选择专业班级
     *
     * @return
     */
    public List<Course> listAll() {
        return courseDao.findAll();
    }

    public List<Course> findAll(Course course) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("courseName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("teacherId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("grade", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("courseId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Course> example = Example.of(course, matcher);
        return courseDao.findAll(example);
    }

    public Page<Course> findAll(Course course, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("courseName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("teacherId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("grade", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("courseId");

        Example<Course> example = Example.of(course, matcher);
        return courseDao.findAll(example, pageable);
    }
}
