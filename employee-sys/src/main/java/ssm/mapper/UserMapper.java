package ssm.mapper;

import ssm.bean.User;

public interface UserMapper {
    //根据用户登陆名和密码查询指定用户
    public User getUserByNameAndPassword(String userName,String password);
    //根据用户名查找指定用户
    public User getUserByName(String userName);
    //增加用户
    public void addUser(String userName,String password);
}
