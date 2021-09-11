package ssm.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssm.bean.Department;
import ssm.bean.Employee;
import ssm.service.DepartmentService;
import ssm.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CRUDHandler {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    /**
     * 显示所有员工信息
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String listAllEmps(Map<String, Object> map) {
        List<Employee> allEmps = employeeService.getAllEmps();
        map.put("emps", allEmps);
        return "list";
    }

    /**
     * 添加功能: 1.去往添加页面
     * 2.获取添加页面需要的部门数据
     */
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String toAddPage(Map<String, Object> map) {

        //1. 获取部门信息
        List<Department> departments = departmentService.getAllDepts();
        map.put("depts", departments);

        //2. 构造页面中生成单选框的数据
        Map<String, String> genders = new HashMap<>();
        genders.put("girl", "女");
        genders.put("boy", "男");
        map.put("genders", genders);


        //3. 设置页面中要回显的数据
        map.put("employee", new Employee());
        return "crud";

    }


    /**
     * 添加功能 : 具体的添加操作
     */

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        //添加员工
        employeeService.addEmp(employee);

        //重定向去往显示全体员工信息列表
        return "redirect:/emps";
    }

    /**
     * 删除功能
     */

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        //删除员工
        employeeService.deleteEmp(id);

        //重定向去往显示全体员工信息列表
        return "redirect:/emps";

    }

    /**
     * 修改功能: 去往修改页面
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id") Integer id, Map<String, Object> map) {

        //1. 查询要修改的员工信息
        Employee employee = employeeService.getEmp(id);
        map.put("employee", employee);

        //2. 获取部门信息
        List<Department> departments = departmentService.getAllDepts();
        map.put("depts", departments);

        //3. 构造页面中生成单选框的数据
        Map<String, String> genders = new HashMap<>();
        genders.put("girl", "女");
        genders.put("boy", "男");
        map.put("genders", genders);

        return "crud";

    }


    /**
     * 修改功能: 具体的修改操作
     */

    @RequestMapping(value = "emp", method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        employeeService.updateEmp(employee);

        return "redirect:/emps";
    }

}
