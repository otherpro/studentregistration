package com.jac.studentregistration.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jac
 * @date 2019-03-29 03:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyServiceImplTest {
    @Autowired
    AcademyServiceImpl aca;

    @Test
    public void test1() {
        System.out.println(aca.get("1"));
    }
}
