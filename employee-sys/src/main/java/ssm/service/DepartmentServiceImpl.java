package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.Department;
import ssm.mapper.DepartmentMapper;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    //获取所有部门数据
    @Override
    public List<Department> getAllDepts() {
        return departmentMapper.getDepts();
    }
}
