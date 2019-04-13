package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.StudentDao;
import com.jac.studentregistration.dao.StudentDao;
import com.jac.studentregistration.entity.Student;
import com.jac.studentregistration.entity.Student;
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
public class StudentServiceImpl  {
    @Autowired
    public StudentDao studentDao;

    //查看所有学院
    public Student save(Student student) {
        return studentDao.save(student);
    }

    public void delete(String id) {
        studentDao.deleteById(id);
    }

    public Student get(String id) {
        return studentDao.getOne(id);
    }

    /**
     * 获取所有学院信息 列表 之后进行二项选择专业班级
     *
     * @return
     */
    public List<Student> listAll() {
        return studentDao.findAll();
    }

    public List<Student> findAll(Student student) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("studentName", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())//模糊查询匹配开头，即{username}%
                .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("exact");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Student> example = Example.of(student, matcher);
        return studentDao.findAll(example);
    }

    public Page<Student> findAll(Student student, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("studentName", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())//模糊查询匹配开头，即{username}%
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("exact");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Student> example = Example.of(student, matcher);
        return studentDao.findAll(example, pageable);
    }
}
