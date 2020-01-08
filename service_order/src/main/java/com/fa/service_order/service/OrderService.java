package com.fa.service_order.service;

import com.fa.service_order.po.Order;

import java.util.List;

/**
 * description:
 * <p>OrderService .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:36
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface OrderService {

    /**
     * 所有订单表信息
     *
     * @return list集合
     */
    List<Order> getOrderList();

    /**
     * 添加订单信息
     *
     * @param order 订单实体
     * @return 保存的订单信息（包含主键）
     */
    Order addOrder(Order order);

    /**
     * 根据订单Id查询订单信息
     *
     * @param id 订单id
     * @return 订单信息
     */
    Order getOrderById(int id);

    /**
     * 根据用户Id查询订单信息
     *
     * @param userId 用户id
     * @return 订单集合
     */
    List<Order> getOrderByUserId(int userId);
}
