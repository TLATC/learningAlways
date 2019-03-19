package com.shawn.learningalways.hrm.service.impl;

import com.shawn.learningalways.hrm.model.User;
import com.shawn.learningalways.hrm.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统名称: learningAlways
 * 模块名称:
 * 类 名 称: UserServiceImpl
 * 软件版权: shawn
 * 功能说明：用户管理Service实现层
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/5/20 13:39
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Service
public class UserServiceImpl implements UserService {

///    @Autowired
//    private UserDao userDao;

    /**
     * 增加用户
     * @param user
     */
    @Override
    public void insertUser(User user) {

    }

    /**
     * 删除用户
     * @param user
     */
    @Override
    public void deleteUser(User user) {

    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void updateUser(User user) {

    }

    /**
     * 查找用户
     * @param user
     * @return
     */
    @Override
    public List<User> selectUser(User user) {
        //todo
        List<User> userList = new ArrayList<>();
        User rUser = new User();
        rUser.setUserName("王小二");
        userList.add(rUser);
        System.out.println("这是查找用户中的serive层的方法=========");
        return userList;
    }
}
