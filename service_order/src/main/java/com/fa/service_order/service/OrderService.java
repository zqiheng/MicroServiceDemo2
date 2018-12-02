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
}
