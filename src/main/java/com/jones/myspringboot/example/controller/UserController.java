package com.jones.myspringboot.example.controller;

import com.jones.myspringboot.example.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 系统名称: mySpringBoot
 * 模块名称: 测试模块
 * 类 名 称: UserController
 * 软件版权: Jones
 * 功能说明：一个restful api示例
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/6/27 20:48
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

@RestController("testUserController")
@RequestMapping(value = "/users")
public class UserController {

    // 创建线程安全的Map
    static Map<Long,User> userMap = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 处理"/users/"的GET请求，用来获取用户列表
     * 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>(userMap.values());
        return userList;
    }

    /**
     * 处理"/users/"的POST请求，用来创建User
     * 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        userMap.put(user.getId(),user);
        return "SUCCESS";
    }

    /**
     * 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
     * url中的id可通过@PathVariable绑定到函数的参数中
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userMap.get(id);
    }

    /**
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id){
        User user = userMap.get(id);
        user.setName("新名字");
        user.setAge(10);
        userMap.put(id,user);
        return "SUCCESS";
    }

    /**
     * 处理"/users/{id}"的DELETE请求，用来删除User
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        userMap.remove(id);
        return "SUCCESS";
    }

}
