package com.fa.service_order.controller;

import com.fa.service_order.po.Order;
import com.fa.service_order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * <p>OrderController .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:47
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * API接口：获取所有订单信息
     *
     * @return
     */
    @GetMapping("/getOrderList")
    public Object getOrderList() {
        Map<String, Object> map = new HashMap<>();
        List<Order> orderList = orderService.getOrderList();
        log.info("OrderController-info：所有订单信息：" + orderList);

        if (orderList != null && orderList.size() > 0){
            map.put("code",0);
            map.put("orderList",orderList);
        }else{
            map.put("code",-1);
        }

        return map;
    }
}
