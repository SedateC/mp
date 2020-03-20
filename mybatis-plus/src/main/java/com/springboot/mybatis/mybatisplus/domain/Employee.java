package com.springboot.mybatis.mybatisplus.domain;

/*
 * @Author SedateC
 * @Description
 * @Date 2020/3/19
 * java bean
 * 建议使用用封装类型
 * 有一个默认值 null
 * 不包装没有
 **/

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_employee")
public class Employee {
    @TableId (value = "id ",type = IdType.AUTO)//主键策略类型   
    private Integer id;
    @TableField("last_name") //数据库中的字段名
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false) //表示数据库不存在该字段
    private Long date;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
