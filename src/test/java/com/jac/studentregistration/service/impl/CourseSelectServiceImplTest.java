package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.CourseDao;
import com.jac.studentregistration.dao.TeacherDao;
import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.entity.CourseSelect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * CourseSelectServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 10, 2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSelectServiceImplTest {
    @Autowired
    CourseDao courseDao;
    @Autowired
    CourseSelectServiceImpl courseSelectService;
    @Autowired
    TeacherDao teacherDao;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getById(String courseSelectId)
     */
    @Test
    public void testGetById() throws Exception {
//TODO: Test goes here...
        CourseSelect courseSelect=courseSelectService.getById("4028b8816a072a80016a072aa2650000");
        System.out.println(courseSelect.getStartTime());

    }

    /**
     * Method: exportCourseSelectUrl(String courseSelectId)
     */
    @Test
    public void testExportCourseSelectUrl() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: executeSeckill(String courseselectId, Long userPhone, String md5)
     */
    @Test
    public void testExecuteSeckill() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: save(CourseSelect courseSelect)
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here...
        List<Course> list = courseDao.findAll();

        CourseSelect courseSelect = null;

        for (Course course : list) {

            courseSelect = new CourseSelect();
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
            courseSelect.setLeftNum(course.getMaxNum());
            courseSelect.setMaxNum(course.getMaxNum());
            courseSelect.setTeacherName(teacherDao.getOne(course.getTeacherId()).getTeacherName());

//    2016-01-01 00:00:00
            String string = "2019-5-24 21:59:06";
            String string2 = "2019-6-24 21:59:06";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            courseSelect.setStartTime(sdf.parse(string));
            courseSelect = courseSelectService.add(courseSelect);
            System.out.println(courseSelect.getCourseSelectId());//会返回数据库中插入的对象

        }


    }

    /**
     * Method: saveBatch(List<CourseSelect> courseSelectList)
     */
    @Test
    public void testSaveBatch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setTime(Date startTime, Date endTime)
     */
    @Test
    public void testSetTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(String id)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: get(String id)
     */
    @Test
    public void testGet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: listAll()
     */
    @Test
    public void testListAll() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAll(CourseSelect courseSelect)
     */
    @Test
    public void testFindAllCourseSelect() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAll(CourseSelect courseSelect, Pageable pageable)
     */
    @Test
    public void testFindAllForCourseSelectPageable() throws Exception {
//TODO: Test goes here... 
    }


} 
