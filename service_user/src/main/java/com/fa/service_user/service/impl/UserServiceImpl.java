package com.fa.service_user.service.impl;

import com.fa.service_user.dao.UserDao;
import com.fa.service_user.po.User;
import com.fa.service_user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * description:
 * <p>UserServiceImpl .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:33
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 获取所有用户列表信息
     * @return 用户列表
     */
    @Override
    public List<User> getAllUserList() {
        return userDao.findAll();
    }

    /**
     * 添加用户信息
     * @return 添加后返回的实体信息，包含数据库主键ID字段
     */
    @Override
    public User insertUserInfo(User user) {
        return userDao.save(user);
    }

    /**
     * 根据用户Id信息删除用户，批量删除
     * @param id id数组
     */
    @Override
    public void deleteUserInfo(int[] id) {
        for(int i:id){
            userDao.deleteById(i);
        }
    }

    /**
     * 根据用户Id获取用户信息
     * @param id 用户id
     * @return
     */
    @Override
    public User getUserById(int id) {
        return userDao.getOne(id);
    }
}
