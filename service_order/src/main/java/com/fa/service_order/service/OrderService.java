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
     * @return list集合
     */
    List<Order> getOrderList();

    /**
     * 添加订单信息
     * @param order 订单实体
     * @return 保存的订单信息（包含主键）
     */
    Order addOrder(Order order);
}
