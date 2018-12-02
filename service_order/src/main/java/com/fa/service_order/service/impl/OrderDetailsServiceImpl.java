package com.fa.service_order.service.impl;

import com.fa.service_order.dao.OrderDetailsDao;
import com.fa.service_order.po.OrderDetails;
import com.fa.service_order.service.OrderDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * description:
 * <p>OrderDetailsServiceImpl .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:42
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Resource
    private OrderDetailsDao orderDetailsDao;

    @Override
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsDao.findAll();
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        return orderDetailsDao.save(orderDetails);
    }
}
