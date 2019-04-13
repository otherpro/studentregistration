package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.AcademyDao;
import com.jac.studentregistration.entity.Academy;
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
public class AcademyServiceImpl {
    @Autowired
    AcademyDao academyDao;

    //查看所有学院
    public Academy save(Academy academy) {
        return academyDao.save(academy);
    }

    public void delete(String id) {
        academyDao.deleteById(id);
    }

    public Academy get(String id) {
        return academyDao.getOne(id);
    }

    /**
     * 获取所有学院信息 列表 之后进行二项选择专业班级
     *
     * @return
     */
    public List<Academy> listAll() {
        return academyDao.findAll();
    }

    public List<Academy> findAll(Academy academy) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("academyName", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("className", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("academyId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Academy> example = Example.of(academy, matcher);
        return academyDao.findAll(example);
    }

    public Page<Academy> findAll(Academy academy, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("academyName", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("className", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("academyId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<Academy> example = Example.of(academy, matcher);
        return academyDao.findAll(example, pageable);
    }


}
