package jdbc.template;

/**
 * Created by Victor.Sobennikov on 16.12.2016.
 */

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import mybatis.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee empRet = new Employee();
        empRet.setIntId(resultSet.getInt("employee_id"));
        empRet.setStrName(resultSet.getString("first_name"));
        empRet.setBdSalary(resultSet.getBigDecimal("salary"));
        Date dtWorkSQL = resultSet.getDate("hire_date");
        java.util.Date dtWork = new Date(dtWorkSQL.getTime()) ;
        empRet.setHireDate(dtWork);

        return empRet;
    }

}
