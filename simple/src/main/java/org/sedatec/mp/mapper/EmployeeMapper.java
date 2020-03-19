package org.sedatec.mp.mapper;

import bean.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import java.util.List;

/*
 * @Author SedateC
 * @Description
 * @Date 2020/3/19
 **/

public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> findAll();
}
