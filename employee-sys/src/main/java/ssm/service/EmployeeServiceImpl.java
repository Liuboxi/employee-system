package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.Department;
import ssm.bean.Employee;
import ssm.mapper.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    //获取所有员工信息
    @Override
    public List<Employee> getAllEmps() {
        return employeeMapper.getAllEmps();
    }

    //获取单个员工信息
    @Override
    public Employee getEmp(Integer id) {
        return employeeMapper.getEmp(id);
    }

    //增加员工
    @Override
    public void addEmp(Employee employee) {
        employeeMapper.addEmp(employee);
    }

    //修改员工信息
    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }

    //删除员工
    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
    }

}
