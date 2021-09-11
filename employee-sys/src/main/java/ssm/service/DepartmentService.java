package ssm.service;

import ssm.bean.Department;

import java.util.List;

public interface DepartmentService {
    //获取所有部门信息
    public List<Department> getAllDepts();
}
