package com.shawn.learningalways.ranklist.controller;

import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.ranklist.model.UserRank;
import com.shawn.learningalways.ranklist.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @ClassName: UserRankController
 * @Description 用户排行榜控制层
 * @author: Shawn Wu
 * @date: 2019/11/26 16:37
 * @version:
 */
@RestController
@RequestMapping("/userRank")
public class UserRankController extends BaseRender {

    @Autowired
    UserRankService userRankService;


    /**
     * @Description 将指定用户分数加1
     * @param userId 用户id
     * @return 
     * @date 2019/11/26 16:47
     * @auther Shawn Wu
     */
    @PostMapping("/addUserScore/{userId}")
    public JsonResult addUserScore(@PathVariable String userId){
        // 由于某种原因，将用户分数加1
        userRankService.incrUserScore(userId);
        return renderSuccess();
    }

    /**
     * @Description 获取用户排序列表
     * @param
     * @return 
     * @date 2019/11/26 16:46
     * @auther Shawn Wu
     */
    @GetMapping("/getUserRankList")
    public JsonResult getUserRankList(){
        Set<UserRank> userRankSet = userRankService.getUserRankList();
        return renderSuccess(userRankSet);
    }

}