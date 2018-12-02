package com.fa.service_product.controller;

import com.fa.service_product.po.Product;
import com.fa.service_product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = new HashMap<>();
        List<Product> list = productService.getPorductList();
        log.info("Product-info:"+list);

        if(list != null && list.size() > 0){
            map.put("code",0);
            map.put("productList",list);
        }else{
            map.put("code",-1);
        }
        return map;
    }

    /**
     * API接口：添加商品信息
     * @param product
     * @return
     */
    @PostMapping("/saveProduct")
    public Object addProjectInfo(Product product){
        log.info("ProductController-info：提交的商品信息："+product);
        Map<String,Object> map = new HashMap<>();

        if(null != product.getName() && null != product.getPrice() && null != product.getStocks()){
            // 保存商品
            Product savedProduct = productService.addProductInfo(product);
            log.info("ProductContro-info：新增商品的主键："+savedProduct.getId());
            if(savedProduct.getId() > 0){
                map.put("code",0);
            }else {
                map.put("code",-1);
            }
        }
        return map;
    }


    /**
     * API接口：根据商品Id信息查询商品信息
     * @param id 商品id
     * @return 商品信息
     */
    @GetMapping("/getProductById")
    public Object getProductById(int id){
        log.info("Product-info:查询的商品id为 "+id);
        Map<String,Object> map = new HashMap<>();
        if(id > 0){
            Product product = productService.getProductById(id);
            log.info("Product-info:查询到的商品信息为： "+product);
            map.put("code",0);
            map.put("product",product);
        }else{
            map.put("code",-1);
        }
        return map;
    }
}
