package com.springboot.mybatis.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.mybatis.mybatisplus.domain.Employee;
import com.springboot.mybatis.mybatisplus.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
 * @Author SedateC
 * @Description
 * @Date 2020/3/20
 **/

/*
* 指定的是数据库字段 不是java 属性
* */
@SpringBootTest
public class EntityWrapperTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void test1(){
        //第一页 每页两条数据

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>()
                .between("age",12,30)
                .eq("gender",1);
        Page<Employee> pageE = employeeMapper.selectPage(new Page<>(1,5),queryWrapper);
        pageE.getRecords().stream().forEach(System.out::println)  ;
    }

    @Test
    void test2(){
        //第一页 每页两条数据

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>()
                .eq("gender",1)
                .like("last_name","c")
               // .or()//(gender = ? AND last_name LIKE ? OR email LIKE ?)
              //  .or(false) and
                .like("email","a");
        List<Employee> pageE = employeeMapper.selectList(queryWrapper);
        pageE.stream().forEach(System.out::println)  ;
    }

    @Test
    void update(){
        Employee employee = new Employee();
        employee.setAge(30);
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<Employee>()
                .eq("last_name","LUCY")
                .lt("age","31");
        int result = employeeMapper.update(employee,updateWrapper);
        System.out.println(result);
    }
}
