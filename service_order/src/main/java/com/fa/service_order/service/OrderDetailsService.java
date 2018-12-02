package com.fa.service_order.service;

import com.fa.service_order.po.OrderDetails;

import java.util.List;

/**
 * description:
 * <p>OrderDetailsService .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:40
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface OrderDetailsService {

    /**
     * 获取所有订单详细表信息
     * @return list集合
     */
    List<OrderDetails> getOrderDetailsList();

    /**
     * 新增订单信息
     * @param orderDetails 封装的订单详细类
     * @return 保存的订单详细信息（包含订单详细Id）
     */
    OrderDetails addOrderDetails(OrderDetails orderDetails);
}
