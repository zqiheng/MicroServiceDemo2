package com.fa.service_user.controller;

import com.fa.service_user.po.User;
import com.fa.service_user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * <p>UserController .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:29
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * API接口：返回用户所有信息
     * @return List集合
     * 请求地址：/user/getAllUserList
     */
    @GetMapping("/getUserList")
    public Object getAllUserList(){
        List<User> list = userService.getAllUserList();
        log.info("UserController-info:"+list);
        return list;
    }

    /**
     * API接口：添加用户信息
     * @param user　用户信息
     * @return 1：添加成功、0：添加失败
     * 请求地址：/user/saveUser
     */
    @PostMapping("/saveUser")
    public Object insertUserInfo(User user){
        log.info("UserController-info提交的参数："+user);
        if(null != user.getName() && !user.getName().equals("")
                && null != user.getAccount() && !user.getAccount().equals("")
                && null != user.getPassword() && !user.getPassword().equals("")
                && null != user.getSex() && !user.getSex().equals("")){
            // 保存用户
            User savedUser = userService.insertUserInfo(user);
            log.info("UserController-info新增用户信息返回的ID："+savedUser.getId());
            if(savedUser.getId() > 0){
                return 1;
            }
        }
        return 0;
    }

    /**
     * API接口：批量删除用户信息
     * @param id id数组
     * @return 1：删除成功、0：表示没有删除的对象
     */
    @PostMapping(value = "/deleteUserById")
    public Object deleteUserInfo(int[] id){
        log.info("UserController-info删除的Id数据："+id);
        if(id.length > 0){
            // 删除用户
            userService.deleteUserInfo(id);
            return 1;
        }else{
            return 0;
        }
    }
}
