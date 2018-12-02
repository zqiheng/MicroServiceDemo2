package com.fa.service_user.dao;

import com.fa.service_user.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 * <p>UserDao .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:30
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface UserDao extends JpaRepository<User,Integer> {
}
