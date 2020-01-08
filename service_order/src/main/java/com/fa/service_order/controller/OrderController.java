package com.fa.service_order.controller;

import com.fa.service_order.po.Order;
import com.fa.service_order.po.OrderDetails;
import com.fa.service_order.service.OrderDetailsService;
import com.fa.service_order.service.OrderService;
import com.fa.service_order.service.ProductFeignClient;
import com.fa.service_order.service.UserFeignClient;
import com.fa.service_order.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
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
    @GetMapping("/list")
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
     * @return 0:添加成功，-1：添加失败
     */
    @PostMapping("/save")
    public Object addOrderInfo(int userId, int productId, int productNum) {
        log.info("OrderController-info：新增订单信息：userID = " + userId
                + "  商品ID = " + productId + "  购买商品数量 = " + productNum);
        Map<String, Object> map = new HashMap<>();

        if (userId > 0 && productId > 0 && productNum > 0) {
            // 根据userId获取用户信息，调用user微服务
            Map<String, Object> userMap = userfeignClient.findUserById(userId);
            Object userObj = userMap.get("user");
            // 将obj对象转化为JsonNode对象
            JsonNode userJson = JsonUtils.strToJsonNode(userObj);

            // 根据productId获取商品信息，调用product微服务
            Map<String, Object> projectMap = productFeignClient.findProductById(productId);
            Object productObj = projectMap.get("product");
            // 将obj对象转化为JsonNode对象
            JsonNode productJson = JsonUtils.strToJsonNode(productObj);

            if (null != userJson) {
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

                if (null != productJson) {
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
                        map.put("code", 0);
                    } else {
                        map.put("code", -1);
                    }
                }
            }
        } else {
            map.put("code", -1);
        }
        return map;
    }

    /**
     * 根据订单Id获取订单信息
     *
     * @param id 订单Id
     * @return 数据集合
     */
    @GetMapping("/get")
    public Object getOrderById(int id) {
        Map<String, Object> map = new HashMap<>();

        if (id > 0) {
            Order order = orderService.getOrderById(id);
            map.put("code", 0);
            map.put("data", order);
        } else {
            map.put("code", -1);
        }
        return map;
    }

    /**
     * 根据用户Id获取用户的订单信息
     *
     * @param userId 用户Id
     * @return 订单信息集合
     */
    @GetMapping("/get/byUser")
    public Object getOrderByUserId(int userId) {
        log.info("OrderController-info：查询的用户Id为 = " + userId);
        Map<String, Object> map = new HashMap<>();

        if (userId > 0) {
            List<Order> orderList = orderService.getOrderByUserId(userId);
            map.put("code", 0);
            map.put("data", orderList);
        } else {
            map.put("code", -1);
        }
        return map;
    }
}
