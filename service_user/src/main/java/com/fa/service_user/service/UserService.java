package com.fa.service_user.service;

import com.fa.service_user.po.User;

import java.util.List;

/**
 * description:
 * <p>UserService .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:32
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface UserService {

    /**
     * 获取所有用户列表信息
     * @return
     */
    List<User> getAllUserList();

    /**
     * 新增用户信息（注册）
     * @param user
     * @return
     */
    User insertUserInfo(User user);

    /**
     * 批量删除用户信息
     * @param id
     */
    void deleteUserInfo(int[] id);

    /**
     * 根据用户Id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(int id);
}
