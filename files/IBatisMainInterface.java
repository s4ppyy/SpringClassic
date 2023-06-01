package mybatis;


import mybatis.mapper.SimpleMapperInterface;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class IBatisMainInterface {
    public static void main(String[] args) {
            SqlSessionFactory sqlSessionFactory;
            Reader reader = null;
            Employee empOne;
            try {
                reader = Resources.getResourceAsReader("mybatis-config-interface.xml"); //Читаем файл с настройками подключения и настройками MyBatis
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                SqlSession session = sqlSessionFactory.openSession();
          //      empOne=session.selectOne(SimpleMapperInterface.getEmployeeById,101);
          //      System.out.println(empOne);
                SimpleMapperInterface simpleMapper = sqlSessionFactory.openSession().getMapper(SimpleMapperInterface.class); //Создаем маппер, из которого и будем вызывать методы

                empOne=simpleMapper.getEmployeeById(102);
                System.out.println(empOne);

//              System.out.println(session.selectList("Employee.getEmployees").size());



//



            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
