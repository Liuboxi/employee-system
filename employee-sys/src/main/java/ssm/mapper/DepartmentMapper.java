package ssm.mapper;

import ssm.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    //查询所有部门信息
    public List<Department> getDepts();

}
