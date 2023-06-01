package jdbc.template;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.Employee;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ClassicRowMapperJDBCTemplate {
    public static void main(String[] args) {
        OracleDataSource dtSource = null;
        try {
            dtSource = new OracleDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dtSource.setURL("jdbc:oracle:thin:@//192.168.56.103:1521/myora12p.net.billing.ru");
        dtSource.setUser("HR13");
        dtSource.setPassword("hr13");

        String sqlString = "select employee_id, first_name, round(salary/13,2) salary, hire_date+1/2 hire_date from employees where employee_id=:v_id";
        Map<String, Object> argMap = new HashMap<>();
        argMap.put("v_id", "100");
        NamedParameterJdbcTemplate nJTemp = new NamedParameterJdbcTemplate(dtSource);

        List<Map<String, Object>> rows = nJTemp.queryForList(sqlString, argMap);
        System.out.println(rows.size());
        Employee empRes=null;
        try {
            empRes = nJTemp.queryForObject(sqlString, argMap, new BeanPropertyRowMapper<Employee>(Employee.class));
            System.out.println(empRes.getIntId());
            System.out.println(empRes.getStrName());
            System.out.println(empRes.getBdSalary());
            System.out.println(empRes.getHireDate());
        }
        catch (EmptyResultDataAccessException e){
            empRes = null;
        }

        Employee empCustom = null;
        System.out.println("Employee Custom");
        try {
            empCustom = (Employee) nJTemp.queryForObject(sqlString, argMap, new EmployeeRowMapper());
            System.out.println(empCustom.getIntId());
            System.out.println(empCustom.getStrName());
            System.out.println(empCustom.getBdSalary());
            System.out.println(empCustom.getHireDate());
        }
        catch (EmptyResultDataAccessException e){
            empCustom = null;
        }




        //http://www.dineshonjava.com/2012/12/using-namedparameterjdbctemplate-in.html#.VlxHfb-IKNg
        //http://www.mkyong.com/spring/spring-jdbctemplate-querying-examples/
    }
}
