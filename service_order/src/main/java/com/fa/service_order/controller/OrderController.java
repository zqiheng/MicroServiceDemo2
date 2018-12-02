package com.fa.service_order.controller;

import com.fa.service_order.po.Order;
import com.fa.service_order.po.OrderDetails;
import com.fa.service_order.service.OrderDetailsService;
import com.fa.service_order.service.OrderService;
import com.fa.service_order.service.ProductFeignClient;
import com.fa.service_order.service.UserFeignClient;
import com.fa.service_order.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private OrderDetailsService orderDetailsService;

    /**
     * 注入UserFeignClient 调用User微服务
     */
    @Resource
    private UserFeignClient userfeignClient;

    /**
     * 注入ProductFeignClient 调用Product微服务
     */
    @Resource
    private ProductFeignClient productFeignClient;

    /**
     * API接口：获取所有订单信息
     *
     * @return 订单list
     */
    @GetMapping("/getOrderList")
    public Object getOrderList() {
        Map<String, Object> map = new HashMap<>();
        List<Order> orderList = orderService.getOrderList();
        log.info("OrderController-info：所有订单信息：" + orderList);

        if (orderList != null && orderList.size() > 0) {
            map.put("code", 0);
            map.put("orderList", orderList);
        } else {
            map.put("code", -1);
        }

        return map;
    }


    /**
     * 添加订单
     *
     * @param userId     用户Id
     * @param productId  商品Id
     * @param productNum 购买的商品数量
     * @return
     */
    @PostMapping("/saveOrder")
    public Object addOrderInfo(int userId, int productId, int productNum) {
        log.info("OrderController-info：新增订单信息：userID = " + userId
                + "  商品ID = " + productId + "  购买商品数量 = " + productNum);
        Map<String, Object> map = new HashMap<>();
        JsonNode userJson = null;
        JsonNode productJson = null;

        if (userId > 0 && productId > 0 && productNum > 0) {
            // 根据userId获取用户信息，调用user微服务
            Map<String, Object> userMap = userfeignClient.findUserById(userId);
            Object userObj = userMap.get("user");
            // 将obj对象转化为JsonNode对象
            userJson = JsonUtils.strToJsonNode(userObj);

            // 根据productId获取商品信息，调用product微服务
            Map<String, Object> projectMap = productFeignClient.findProductById(productId);
            Object productObj = projectMap.get("product");
            // 将obj对象转化为JsonNode对象
            productJson = JsonUtils.strToJsonNode(productObj);

            if( null != userJson && !userJson.equals("")){
                // 封装订单信息
                Order newOrder = new Order();
                newOrder.setCreateTime(new Date());
                newOrder.setOrderNo("" + userId + System.currentTimeMillis());
                newOrder.setUserId(userId);
                newOrder.setUserName(userJson.get("name").toString());
                newOrder.setOrderStatus(1);
                // 保存订单信息
                Order savedOrder = orderService.addOrder(newOrder);
                log.info("OrderController-info：新增订单的主键：" + savedOrder.getId());

                if(null != productJson && !productJson.equals("")){
                    // 封装订单详情信息
                    OrderDetails newOrderDetails = new OrderDetails();
                    newOrderDetails.setOrder(newOrder);
                    newOrderDetails.setProductId(Integer.parseInt(productJson.get("id").toString()));
                    newOrderDetails.setProductName(productJson.get("name").toString());
                    newOrderDetails.setProductPrice(Float.parseFloat(productJson.get("price").toString()));
                    newOrderDetails.setProductNum(productNum);

                    OrderDetails savedOrderDetails = orderDetailsService.addOrderDetails(newOrderDetails);
                    log.info("OrderController-info：新增的订单详情主键：" + savedOrderDetails.getId());

                    if (savedOrder.getId() > 0 && savedOrderDetails.getId() > 0) {
                        map.put("code",0);
                    }else{
                        map.put("code",-1);
                    }
                }
            }
        } else {
            map.put("code", -1);
        }
        return map;
    }
}
