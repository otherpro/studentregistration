package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.TeacherDao;
import com.jac.studentregistration.entity.Teacher;
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
public class TeacherServiceImpl {
    @Autowired
    public TeacherDao teacherDao;

    //查看所有学院
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    public void delete(String id) {
        teacherDao.deleteById(id);
    }

    public Teacher get(String id) {
        return teacherDao.getOne(id);
    }

    /**
     * 获取所有学院信息 列表 之后进行二项选择专业班级
     *
     * @return
     */
    public List<Teacher> listAll() {
        return teacherDao.findAll();
    }

    public List<Teacher> findAll(Teacher teacher) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("teacherName", ExampleMatcher.GenericPropertyMatchers.contains())//模糊查询匹配开头，即{username}%
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("teacherId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Teacher> example = Example.of(teacher, matcher);
        return teacherDao.findAll(example);
    }

    public Page<Teacher> findAll(Teacher teacher, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("teacherName", ExampleMatcher.GenericPropertyMatchers.contains())//模糊查询匹配开头，即{username}%
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("teacherId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Teacher> example = Example.of(teacher, matcher);
        return teacherDao.findAll(example, pageable);
    }

}
