package com.springboot.mybatis.mybatisplus;

import com.springboot.mybatis.mybatisplus.domain.Employee;
import com.springboot.mybatis.mybatisplus.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {
       List<Employee> employees =  employeeMapper.selectList(null);
       employees.stream().forEach(System.out::println);
    }
    @Test
    public void insert(){
        Employee employee = new Employee();
        employee.setAge(123);
        employee.setEmail("sdadsad@qq.com");
        employee.setGender(2);
        employee.setLastName("LUCY");
        employeeMapper.insert(employee);
    }
}
