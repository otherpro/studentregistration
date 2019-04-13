package com.jac.studentregistration.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/** 
* CourseServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 8, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Autowired
    private CourseServiceImpl courseService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(Course course) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(String id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(Course course) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: get(String id) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: listAll() 
* 
*/ 
@Test
public void testListAll() throws Exception {
    List list=courseService.listAll();
    list.stream().forEach(System.out::println);
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(Course course) 
* 
*/ 
@Test
public void testFindAllCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(Course course, Pageable pageable) 
* 
*/ 
@Test
public void testFindAllForCoursePageable() throws Exception { 
//TODO: Test goes here... 
} 


} 
