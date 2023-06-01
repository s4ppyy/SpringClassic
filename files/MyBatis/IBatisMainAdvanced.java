package mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class IBatisMainAdvanced {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        Reader reader = null;
        Employee empOne;
        try {
            reader = Resources.getResourceAsReader("mybatis-adv-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            Date dtMy = Date.from(LocalDateTime.parse("1987-06-17T16:00").atZone(ZoneId.systemDefault()).toInstant());
            Map mapPar = new HashMap<String, Object>();
            mapPar.put("fname", "Steven");
            mapPar.put("hdate", dtMy);


            empOne = session.selectOne("Employee.getEmployeeById", mapPar);
            System.out.println(session.selectList("Employee.getEmployees").size());

            System.out.println(empOne);
            try {
                session.update("Employee.dropT");
            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage());
            }
            session.update("Employee.createT");
            session.insert("Employee.insertT", mapPar);

            session.commit();


            // вызов Oracle Stored Procedure with out-cursor
            //   http://stackoverflow.com/questions/15666856/calling-oracle-stored-procedures-with-mybatis
            mapPar.clear();
            ResultSet rs = null;
            mapPar.put("p_out", rs);
            mapPar.put("p_in",101);
            session.selectOne("Employee.getEmpProc", mapPar);
            List<Employee> lEmp= (List<Employee>) mapPar.get("p_out");
            lEmp.stream().forEach(System.out::println);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
