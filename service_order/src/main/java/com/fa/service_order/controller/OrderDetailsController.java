package com.fa.service_order.controller;

import com.fa.service_order.po.OrderDetails;
import com.fa.service_order.service.OrderDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * <p>OrderDetailsController .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:52
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/orderdetails")
public class OrderDetailsController {

    @Resource
    private OrderDetailsService orderDetailsService;

    public Object getOrderDetailsList(){
        List<OrderDetails> orderDetailsList = orderDetailsService.getOrderDetailsList();
        log.info("OrderDetailsController-info:所有订单详细信息："+orderDetailsList);
        return orderDetailsList;
    }
}
