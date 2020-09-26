package com.shawn.learningalways.redisuse.controller;

import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.base.util.DateTimeUtil;
import com.shawn.learningalways.redisuse.model.SignInVO;
import com.shawn.learningalways.redisuse.model.UserSignIn;
import com.shawn.learningalways.redisuse.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SignInController
 * 用户签到的控制层
 * 使用redis的bitMap实现签到的记录和统计
 *
 * @author Shawn Wu
 * @date 2020/9/25 11:55
 * @since v1
 */
@RestController
@RequestMapping("/signIn")
public class SignInController extends BaseRender{

    private final SignInService signInService;

    @Autowired
    public SignInController(SignInService signInService) {
        this.signInService = signInService;
    }


    /**
     * 用户签到
     *
     * @param userSignIn userId 用户id
     * @return 签到结果
     * @date 2020/9/25 11:59
     * @author Shawn Wu
     */
    @PostMapping("/signIn")
    public JsonResult signIn(@RequestBody UserSignIn userSignIn){
        signInService.signIn(userSignIn);
        return renderSuccess();
    }

    /**
     * 判断用户本日是否已经签到过
     *
     * @param userSignIn 用户id
     * @return true：已签到，false：未签到
     * @date 2020/9/25 16:04
     * @author Shawn Wu
     */
    @PostMapping("/isSignInToday")
    public JsonResult isSignInToday(@RequestBody UserSignIn userSignIn){
        boolean signInFlag = signInService.isSingIn(userSignIn.getUserId(), DateTimeUtil.getNowDateEN());
        return renderSuccess(signInFlag);
    }

    /**
     * 获取指定日期的活跃用户数量
     *
     * @param signInVO startTime 指定日期（格式yyyy-mm-hh）
     * @return 活跃用户数量
     * @date 2020/9/26 17:32
     * @author Shawn Wu
     */
    @PostMapping("/getSignCountSpecifiedDay")
    public JsonResult getSignCountSpecifiedDay(@RequestBody SignInVO signInVO){
        long count =  signInService.getActiveUserCountSpecified(signInVO.getStartTime());
        return renderSuccess(count);
    }

    /**
     * 获取指定时间段内的活跃用户数
     *
     * @param signInVO beginDay 开始日期（格式yyyy-mm-hh）
     *                 endDay 结束日期（格式yyyy-mm-hh）
     * @return 活跃用户数
     * @date 2020/9/26 18:33
     * @author Shawn Wu
     */
    @PostMapping("/getSignCountScope")
    public JsonResult getSignCountScope(@RequestBody SignInVO signInVO){
        long count =  signInService.getActiveUserCount(signInVO.getStartTime(), signInVO.getEndTime());
        return renderSuccess(count);
    }
}