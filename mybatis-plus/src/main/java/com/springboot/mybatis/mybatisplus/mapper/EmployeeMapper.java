package com.springboot.mybatis.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.mybatis.mybatisplus.domain.Employee;

import org.springframework.stereotype.Repository;

/*
 * @Author SedateC
 * @Description
 * @Date 2020/3/19
 **/

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
