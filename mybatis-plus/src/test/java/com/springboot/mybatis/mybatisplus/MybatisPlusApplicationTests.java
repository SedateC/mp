package com.springboot.mybatis.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.mybatis.mybatisplus.domain.Employee;
import com.springboot.mybatis.mybatisplus.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
/*
sql session 中 mybatis configuration
* 启动好会自动生成mapper接口中 mappedStatement 中对应实例的SQL 语句
*
* */
@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {
       List<Employee> employees =  employeeMapper.selectList(null);
       employees.stream().forEach(System.out::println);
    }
    /*
    * */
    @Test
    public void insert(){
        Employee employee = new Employee();
        employee.setAge(123);
        employee.setEmail("sdadsad@qq.com");
        employee.setGender(2);
        employee.setLastName("LUCY");
        int result = employeeMapper.insert(employee);
        System.out.println(result);
        System.out.println(employee.getId());/* 直接可以获取插入后的主键值*/
    }
    /*
    * 为空的字段不会出现SQL语句中
    * */
    @Test
    public void update(){
        Employee employee = new Employee();
        employee.setId(5);
        employee.setEmail("aaa@qq.com");
        int result = employeeMapper.updateById(employee); //result 数据库影响条数
        System.out.println(employee); //没有返回查询出的数据
    }


    @Test void select(){
        //1,id查询
        Employee employee =  employeeMapper.selectById(6);
        System.out.println(employee);
        //2,多个列查询
        employee.setAge(18);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Employee> e = employeeMapper.selectBatchIds(list);
        e.stream().forEach(System.out::println);
        //3 select by map
        Map map = new HashMap();
        map.put("last_name","Tom"); //一定要写数据库中的列名
        map.put("gender",1);
        List<Employee> e1 = employeeMapper.selectByMap(map);
        e1.stream().forEach(System.out::println);
        //4 select page
        /*查询 第二页 第二条数具*/
         Page<Employee> pageE = employeeMapper.selectPage(new Page<>(2,2),null);
        System.out.println(pageE);
        pageE.getRecords().stream().forEach(System.out::println);
    }

    @Test
    void delete(){
        //1 id删除
      int result = employeeMapper.deleteById(9);
        System.out.println(result);

        //2条件删除

        Map map = new HashMap();
        map.put("last_name","Tom"); //一定要写数据库中的列名
        map.put("gender",1);
        result =   employeeMapper.deleteByMap(map);
        System.out.println(result);
        /*
        * id 批量删除
        * */
        List<Integer> list = new ArrayList<>();
      /*  list.add(1);
        list.add(2);*/
        employeeMapper.selectBatchIds(list);
    }
}
