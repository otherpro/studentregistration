package com.jac.studentregistration.web;

import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.entity.Seckill;
import com.jac.studentregistration.service.SeckillService;
import com.jac.studentregistration.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/course")//url:模块/资源/{}/细分
public class AcademyController {

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //list.jsp+mode=ModelAndView
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam(required = false) String grade,
                        @RequestParam(required = false) String academy,
                        @RequestParam(required = false) String classname,
                        @RequestParam(required = false) String sno,
                        Model model) {
        //list.jsp+mode=ModelAndView
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }


    /**
     * @param course 用户修改后传回来的post
     * @MethodName:save
     * @Description:保存员工
     * @return: 返回成功信息，以Json格式
     */
    @PostMapping
    public Map save(@RequestBody Course course) {
        Map<String, Object> map = new HashMap<String, Object>();
        courseService.save(course);
        map.put("massage", "success save");
        return map;
    }

    /**
     * @param studentId
     * @MethodName:get
     * @Description:根据studentId获取员工
     * @return: 返回员工信息, 以json格式
     */
    @GetMapping(value = "/{studentId}")
    public Map get(@PathVariable(value = "studentId", required = true) String studentId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Course course = courseService.get(studentId);
        map.put("course", course);
        return map;
    }

    /**
     * 根据学院、教师、课程名称进行搜索
     *
     * @param username
     * @param teacher
     * @param coursename
     * @param model
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam(required = false) String username,
                        @RequestParam(required = false) String teacher,
                        @RequestParam(required = false) String coursename,
                        Model model) {
        //list.jsp+mode=ModelAndView
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * @param studentId URL占位符参数
     * @MethodName:delete
     * @Description:删除员工
     * @return: 返回员工列表, 以json格式
     */
    @DeleteMapping(value = "/{studentId}")
    public Map delete(@PathVariable(required = true) String studentId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Course course = courseService.get(studentId);
        courseService.delete(course);
        map.put("massage", "success delete");
        return map;
    }

    /**
     * @param course 用户修改后传回来的post
     * @MethodName:update
     * @Description:更新员工
     * @return: 返回成功信息, 以json格式
     */
    @PutMapping
    public Map update(@RequestBody Course course) {
        Map<String, Object> map = new HashMap<String, Object>();
        courseService.save(course);
        map.put("massage", "success update");
        return map;
    }

    /**
     * @param course
     * @MethodName:list
     * @Description:获取员工列表
     * @return: 返回员工列表, 以json格式
     */
    @GetMapping()
    public Map list(Course course, Integer pageNo, Integer pageSize, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Course> students = courseService.findList(course);
        map.put("students", students);
        return map;
    }


}























