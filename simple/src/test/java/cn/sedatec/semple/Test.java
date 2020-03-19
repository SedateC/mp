package cn.sedatec.semple;

import bean.Employee;
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.sedatec.mp.mapper.EmployeeMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * @Author SedateC
 * @Description
 * @Date 2020/3/19
 **/
public class Test {
    @org.junit.Test
    public void testFindAll() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        EmployeeMapper employeeMapper =  sqlSession.getMapper(EmployeeMapper.class);
        /*   ;   List<Employee> list  =  employeeMapper.findAll();
       for (Employee employee :list){
           System.out.println(employee);
       }*/

        List<Employee> list = employeeMapper.selectList(null);
        list.stream().forEach(System.out::println);
    }
}
