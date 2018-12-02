package com.fa.service_order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * description: Feign商品客户调用端，@FeignClient(name = "service-product")表明需要调用的服务
 * <p>ProductFeignClient .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 17:57
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@FeignClient(name = "service-product")
public interface ProductFeignClient {

    /**
     * 注意：
     *  1. @GetMapping("/api/v1/product/getProductById")中的路由要与商品服务路由相同
     *  2. 参数要保持一致
     *  3. 返回参数保持一致
     * @param id 商品编号
     * @return 封装的商品信息
     */
    @GetMapping("/api/v1/product/getProductById")
    Map<String,Object> findProductById(@RequestParam(value = "id") int id);

}
