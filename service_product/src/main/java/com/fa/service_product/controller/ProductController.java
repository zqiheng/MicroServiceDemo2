package com.fa.service_product.controller;

import com.fa.service_product.po.Product;
import com.fa.service_product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * <p>ProductController .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:50
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/product")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * API接口：获取所有商品信息
     * @return 商品集合list
     */
    @GetMapping("/getProductList")
    public Object getProductList(){
        List<Product> list = productService.getPorductList();
        log.info("Product-info:"+list);
        return list;
    }


    /**
     * API接口：根据商品Id信息查询商品信息
     * @param id 商品id
     * @return 商品信息
     */
    @GetMapping("/getProductById")
    public Object getProductById(int id){
        log.info("Product-info:查询的商品id为 "+id);
        Product product = null;
        if(id > 0){
            product = productService.getProductById(id);
            log.info("Product-info:查询到的商品信息为： "+product);
        }
        return product;
    }
}
