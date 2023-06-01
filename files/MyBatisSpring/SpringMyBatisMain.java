package mybatis.spring;


import mybatis.Employee;
import mybatis.mapper.SimpleMapperInterface;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.SQLException;

public class SpringMyBatisMain {
    public static void main(String[] args) {
        //https://www.javacodegeeks.com/2012/02/mybatis-3-spring-integration-tutorial.html
        ApplicationContext ctx=new ClassPathXmlApplicationContext("springConfig.xml");
        try {
            System.out.println(ctx.getBean("orclDataSource",OracleDataSource.class).getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory;
        sqlSessionFactory = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.selectOne("mybatis.mapper.SimpleMapperInterface.getEmployeeById",1);

        SimpleMapperInterface sMapper=sqlSession.getMapper(SimpleMapperInterface.class);
        sMapper.getEmployeeById(100);

        sqlSessionFactory.openSession().selectOne("mybatis.mapper.SimpleMapperInterface.getEmployeeById", 1);

        SimpleMapperInterface mapEmp= ctx.getBean("employeeMapper",SimpleMapperInterface.class);
        Employee empOne = mapEmp.getEmployeeById(new Integer(100));
        System.out.println(empOne);
    }
}
