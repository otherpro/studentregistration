package com.jac.studentregistration.web;

import com.jac.studentregistration.dto.Exposer;
import com.jac.studentregistration.dto.SeckillExecution;
import com.jac.studentregistration.dto.SeckillResult;
import com.jac.studentregistration.entity.Seckill;
import com.jac.studentregistration.entity.Student;
import com.jac.studentregistration.enums.SeckillStatEnum;
import com.jac.studentregistration.exception.RepeatKillException;
import com.jac.studentregistration.exception.SeckillCloseException;
import com.jac.studentregistration.service.SeckillService;
import com.jac.studentregistration.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/student")//url:模块/资源/{}/细分
public class StuInfoController
{
    @Autowired
    private SeckillService seckillService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)
    {
        //list.jsp+mode=ModelAndView
        //获取列表页
        List<Seckill> list=seckillService.getSeckillList();
        model.addAttribute("list",list);
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
     * @MethodName:save
     * @Description:保存员工
     * @param student 用户修改后传回来的post
     * @return: 返回成功信息，以Json格式
     */
    @PostMapping
    public Map save(@RequestBody Student student){
        Map<String,Object> map = new HashMap<String,Object>();
        studentService.save(student);
        map.put("massage","success save");
        return map;
    }

    /**
     * @MethodName:get
     * @Description:根据studentId获取员工
     * @param studentId
     * @return: 返回员工信息,以json格式
     */
    @GetMapping(value = "/{studentId}")
    public  Map get(@PathVariable(value = "studentId",required = true) String studentId){
        Map<String,Object> map=new HashMap<String,Object>();
        Student student = studentService.get(studentId);
        map.put("student",student);
        return map;
    }

    /**
     * @MethodName:delete
     * @Description:删除员工
     * @param studentId  URL占位符参数
     * @return: 返回员工列表,以json格式
     */
    @DeleteMapping(value = "/{studentId}")
    public Map delete(@PathVariable(required = true) String studentId){
        Map<String,Object> map=new HashMap<String,Object>();
        Student student = studentService.get(studentId);
        studentService.delete(student);
        map.put("massage","success delete");
        return map;
    }

    /**
     * @MethodName:update
     * @Description:更新员工
     * @param student 用户修改后传回来的post
     * @return: 返回成功信息,以json格式
     */
    @PutMapping
    public Map update(@RequestBody Student student){
        Map<String,Object> map=new HashMap<String,Object>();
        studentService.save(student);
        map.put("massage","success update");
        return map;
    }

    /**
     * @MethodName:list
     * @Description:获取员工列表
     * @param student
     * @return: 返回员工列表,以json格式
     */
    @GetMapping()
    public Map list(Student student,Integer pageNo, Integer pageSize, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Student> students =  studentService.findList(student);
        map.put("students",students);
        return map;
    }


}























