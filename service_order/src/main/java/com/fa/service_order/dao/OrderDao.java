package com.fa.service_order.dao;

import com.fa.service_order.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * description:
 * <p>OrderDao .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:35
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface OrderDao extends JpaRepository<Order,Integer> {

    /**
     * JPA查询：根据用户Id查询订单信息
     * @param userId 用户id
     * @return 用户订单集合
     */
    List<Order> findByUserId(int userId);
}
