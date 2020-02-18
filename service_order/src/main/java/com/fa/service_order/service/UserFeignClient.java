package com.fa.service_order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * description: Feign用户客户调用端，@FeignClient(name = "service-user")表明需要调用的服务
 * <p>UserFeignClient .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 15:42
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@FeignClient(name = "service-user")
public interface UserFeignClient {

    /**
     * 注意：
     * 1. @GetMapping("/api/v1/user/getUserById")中的路由要与用户业务路由相同
     * 2. 参数要保持一致
     * 3. 返回参数保持一致
     *
     * @param id
     * @return
     */
    @GetMapping("/api/v1/user/get")
    Map<String, Object> findUserById(@RequestParam(value = "id") int id);
}
