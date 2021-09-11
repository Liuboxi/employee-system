package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.User;
import ssm.mapper.UserMapper;

@Service
public class UserSerivceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByNameAndPassword(String userName,String password) {
        return userMapper.getUserByNameAndPassword(userName,password);
    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public void addUser(String userName, String password) {
        userMapper.addUser(userName,password);
    }
}
