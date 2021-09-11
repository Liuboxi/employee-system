package ssm.service;

import ssm.bean.Department;
import ssm.bean.Employee;

import java.util.List;

public interface EmployeeService {

    //获取所有员工信息
    public List<Employee> getAllEmps();

    //获取单个员工信息
    public Employee getEmp(Integer id);

    //增加员工
    public void addEmp(Employee employee);

    //修改员工信息
    public void updateEmp(Employee employee);

    //删除员工
    public void deleteEmp(Integer id);

}
