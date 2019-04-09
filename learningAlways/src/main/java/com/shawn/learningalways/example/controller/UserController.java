package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.example.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 系统名称: learningAlways
 * 模块名称: 测试模块
 * 类 名 称: UserController
 * 软件版权: shawn
 * 功能说明：一个restful api示例
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/6/27 20:48
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

@RestController("testUserController")
@RequestMapping(value = "/users")
public class UserController {

    /**
     * 创建线程安全的Map
     */
    static Map<Long,User> userMap = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 处理"/users/"的GET请求，用来获取用户列表
     * 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
     *
     * @ApiOperation 给API增加说明
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>(userMap.values());
        return userList;
    }

    /**
     * 处理"/users/"的POST请求，用来创建User
     * 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
     *
     * @ApiImplicitParam 给参数增加说明
     * @param user
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
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
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userMap.get(id);
    }

    /**
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     * @param id
     * @return
     */
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    // 使用@ModelAttribute注解的实体类接收前端发来的数据格式需要为"x-www-form-urlencoded"，@RequestBody注解的实体类接收前端的数据格式为JSON(application/json)格式。
    public String putUser(@PathVariable Long id, @RequestBody User user){
        User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id,u);
        return "SUCCESS";
    }

    /**
     * 处理"/users/{id}"的DELETE请求，用来删除User
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        userMap.remove(id);
        return "SUCCESS";
    }
}
