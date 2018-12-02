package com.fa.service_product.service;

import com.fa.service_product.po.Product;

import java.util.List;

/**
 * description:
 * <p>ProductService .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:49
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface ProductService {

    /**
     * 查询所有商品列表信息
     * @return
     */
    List<Product> getPorductList();

    /**
     * 根据商品ID获取商品信息
     * @param id
     * @return
     */
    Product getProductById(int id);
}
