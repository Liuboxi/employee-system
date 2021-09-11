package ssm.mapper;

import ssm.bean.Department;
import ssm.bean.Employee;

import java.util.List;


public interface EmployeeMapper {
    //查询employees表中所有的数据
    public List<Employee> getAllEmps();

    //查询单个employee的数据
    public Employee getEmp(Integer id);

    //增加员工
    public void addEmp(Employee employee);

    //修改员工信息
    public void updateEmp(Employee employee);

    //删除员工
    public void deleteEmp(Integer id);

}
