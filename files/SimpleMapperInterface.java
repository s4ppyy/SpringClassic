package mybatis.mapper;

import mybatis.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SimpleMapperInterface {
    public Employee getEmployeeById(int id);
    public List<Employee> getEmployees();
}
