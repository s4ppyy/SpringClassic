package mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class IBatisMain {
    public static void main(String[] args) {
            SqlSessionFactory sqlSessionFactory;
            Reader reader = null;
            Employee empOne;
            try {
                reader = Resources.getResourceAsReader("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                SqlSession session = sqlSessionFactory.openSession();
                empOne=session.selectOne("Employee.getEmployeeById",new Integer(100));
                System.out.println(session.selectList("Employee.getEmployees").size());

                System.out.println(empOne);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
