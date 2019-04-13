package com.jac.studentregistration.service.impl; 

import com.jac.studentregistration.dao.CourseDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/** 
* StudentCourseServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 12, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentCourseServiceImplTest { 
@Autowired
StudentCourseServiceImpl studentCourseService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: save(StudentCourse studentCourse) 
* 
*/ 
@Test
public void testSave() throws Exception { 
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
* Method: get(String id) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: listByStuIdAndSortByLesson(String studentId) 
* 
*/
@Autowired
    CourseDao courseDao;
@Test
public void testListByStuIdAndSortByLesson() throws Exception { 
//TODO: Test goes here...
    studentCourseService.listByStuIdAndSortByLesson("1").forEach(System.out::println);

} 

/** 
* 
* Method: listByStuIdAndGrade(String studentId, String grade) 
* 
*/ 
@Test
public void testListByStuIdAndGrade() throws Exception { 
//TODO: Test goes here...
    studentCourseService.listByStuIdAndGrade("1","2018-2019-1").forEach(System.out::println);
} 

/** 
* 
* Method: listAll() 
* 
*/ 
@Test
public void testListAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(StudentCourse studentCourse) 
* 
*/ 
@Test
public void testFindAllStudentCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(StudentCourse studentCourse, Pageable pageable) 
* 
*/ 
@Test
public void testFindAllForStudentCoursePageable() throws Exception { 
//TODO: Test goes here... 
} 


} 
