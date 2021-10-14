package com.xiexin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexin.bean.Student;
import com.xiexin.bean.StudentExample;
import com.xiexin.respcode.Result;
import com.xiexin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 全查  注意 不用map， 公司中 都用  一个 类， 好几类组成的类， 叫做
    // 统一响应类， 每个公司都不一样。
    @RequestMapping("/selectAll") // /student/selectAll
    public Result selectAll(){
        List<Student> students = studentService.selectByExample(null);// select * from student
        Result  result =new Result(students);
        return result;
    }

   /* //  （带参数的）分页查询
    @RequestMapping("/selectPageAll") // /student/selectPageAll
    public Result selectPageAll(Student student,@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = true)Integer pageSize){
        System.out.println("student = " + student);
        StudentExample example=new StudentExample();
        StudentExample.Criteria criteria=example.createCriteria();
     //使用的是 pagehelper 分页
        PageHelper.startPage(page,pageSize);
        if(null !=student.getStudentSex()&&!"".equals(student.getStudentSex())){
            criteria.andStudentSexEqualTo(student.getStudentSex());
        }
        List<Student> students = studentService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(students);
        Result result = new Result(pageInfo);
        return result;
    }
*/
    //  （带参数的）分页查询
    @RequestMapping("/selectPageAll") // /student/selectPageAll
    public Result selectPageAll(Student student,@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = true)Integer pageSize){
        System.out.println("student = " + student);
        StudentExample example=new StudentExample();
        StudentExample.Criteria criteria=example.createCriteria();
        //使用的是 pagehelper 分页
        PageHelper.startPage(page,pageSize);
        if(null !=student.getStudentName()&&!"".equals(student.getStudentName())){
            criteria.andStudentNameEqualTo(student.getStudentName());
        }

        if(null !=student.getStudentSex()&&!"".equals(student.getStudentSex())){
            criteria.andStudentSexEqualTo(student.getStudentSex());
        }
        List<Student> students = studentService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(students);
        Result result = new Result(pageInfo);
        return result;
    }


}
