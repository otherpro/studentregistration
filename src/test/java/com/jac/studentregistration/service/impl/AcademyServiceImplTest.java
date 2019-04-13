package com.jac.studentregistration.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jac.studentregistration.entity.Academy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Jac
 * @date 2019-03-29 03:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyServiceImplTest {
    @Autowired
    AcademyServiceImpl acaService;
    @Test
    public void get() {
        acaService.get("1");
    }
    @Test
    public void save() {
        Academy academy=new Academy();
        academy.setAcademyName("test2");
        academy.setClassName("test1class2");
        academy.setStatus("0");
        acaService.save(academy);
    }
    @Test
    public void delete() {
        acaService.delete("1");
    }
    @Test
    public void listAll() {
//        System.out.println(acaService.listAll());
        acaService.listAll().stream().forEach(System.out::println);
    }
    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);

        Academy academy=new Academy();
        academy.setAcademyName("test2");
        academy.setClassName("test1class2");
        academy.setStatus("0");
        Page<Academy> page=acaService.findAll(academy, pageRequest);
        System.out.println(page.toString());
    }

    @Test
    public void test1() {
        Academy aca=acaService.get("1");
        System.out.println(aca.toString());
    }
}
