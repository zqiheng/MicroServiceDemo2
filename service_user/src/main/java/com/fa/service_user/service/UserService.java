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

    List<User> getAllUserList();

    User insertUserInfo(User user);

    void deleteUserInfo(int[] id);
}
