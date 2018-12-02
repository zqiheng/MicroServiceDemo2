package com.fa.service_order.service.impl;

import com.fa.service_order.dao.OrderDao;
import com.fa.service_order.po.Order;
import com.fa.service_order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * description:
 * <p>OrderServiceImpl .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:39
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public List<Order> getOrderList() {
        return orderDao.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        return orderDao.save(order);
    }

}
