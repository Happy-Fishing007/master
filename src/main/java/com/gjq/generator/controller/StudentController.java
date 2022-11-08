package com.gjq.generator.controller;


import com.gjq.generator.mapper.StudentMapper;
import com.gjq.generator.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gjq
 * @since 2022-10-12
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;


    @RequestMapping("/zj")
    public String zj(Model model) {
//        QueryWrapper<Batchpay> batchpay = new QueryWrapper<>();
//        batchpay.eq("batch_no","1");
//        List<Batchpay> batchpays = batchpayMapper.selectList(batchpay);
//        batchpays.forEach(a-> System.out.println(a));
//        Batchpay batchpay = batchpayMapper.selectById("1");
//        System.out.println(batchpay);
//        Student student = studentMapper.selectById("1");
//        System.out.println(student);

        List<Student> students = initStudent();
        Long startTime=System.currentTimeMillis();
        System.out.println("开始时间："+startTime);
        zjInsert(students);
        Long endTime=System.currentTimeMillis();
        System.out.println("结束时间："+endTime);
        System.out.println("直接插入用时："+(endTime-startTime));
//        model.addAttribute("msg", "hello");
        return "login";
    }

    @RequestMapping("/fp")
    public String fp( ) {
        List<Student> students = initStudent();
        Long startTime=System.currentTimeMillis();
        System.out.println("开始时间："+startTime);
        batchInsert(students);
        Long endTime=System.currentTimeMillis();
        System.out.println("结束时间："+endTime);
        System.out.println("分批插入用时："+(endTime-startTime));

        return "login";
    }

    @RequestMapping("/dxc")
    public String dxc( ) {
        List<Student> students = initStudent();
        Long startTime=System.currentTimeMillis();
        System.out.println("开始时间："+startTime);
        dxcInsert(students);
        Long endTime=System.currentTimeMillis();
        System.out.println("结束时间："+endTime);
        System.out.println("多线程插入用时："+(endTime-startTime));
        return "login";
    }

    /*
     * 直接插入
     * */
    public List<Student> initStudent() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            Student student = new Student();
            student.setName("lanjian" + i);
            student.setPhone("qq" + i);
            students.add(student);
        }
        return students;
    }

    /*
     * 拆分list
     * */
    public  <T> List<List<T>> splitList(List<T> t) {
        if (t.isEmpty()) {
            System.out.println("list为null");
            return null;
        } else {
            int size = t.size();
            int a = 100;
            int b = size / a;
            int c = size % size;
            List<List<T>> shareList = new ArrayList<>();
            for (int i = a; i <= a * b; i = i + a) {
                shareList.add(t.subList(i - a, i));
            }
            if (c != 0) {
                shareList.add(t.subList(a * b, size));
            }
            return shareList;
        }
    }
    /*
     * 分批插入
     * */
    public void batchInsert(List<Student> students) {
        List<List<Student>> lists = splitList(students);

        for (int i = 0; i < lists.size(); i++) {
            studentMapper.saveAll(lists.get(i));
        }
//        lists.forEach(a->{
//            studentMapper.saveAll(a);
//        });
    }

    /*
     * 直接插入
     * */
    public void zjInsert(List<Student> students) {
        studentMapper.saveAll(students);
    }

    /*
     * 多线程
     * */
    public <T> void dxcInsert(List<T> u){
    int size=u.size();
    int t=20;
        ExecutorService executorService = Executors.newFixedThreadPool(t);
        for (int i = 0; i <t ; i++) {
            List<T> ts = u.subList(size / t * i, size / t * (i + 1));
            executorService.submit(()->{
                Long l=System.currentTimeMillis();
                batchInsert((List<Student>) ts);
                System.out.println(System.currentTimeMillis()-l);
            });
        }
        executorService.shutdown();
    }
}
