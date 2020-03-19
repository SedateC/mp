package cn.sedatec.semple;

import bean.Employee;
import org.sedatec.mp.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * @Author SedateC
 * @Description
 * @Date 2020/3/19
 **/
public class TestMybatis {



    @Test
    public void testFindAll() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
       EmployeeMapper employeeMapper =  sqlSession.getMapper(EmployeeMapper.class);
      ;   List<Employee> list  =  employeeMapper.findAll();
       for (Employee employee :list){
           System.out.println(employee);
       }
    }
}
