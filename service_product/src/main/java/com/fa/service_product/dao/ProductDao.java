package com.fa.service_product.dao;

import com.fa.service_product.po.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 * <p>ProductDao .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:48
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface ProductDao extends JpaRepository<Product,Integer> {
}
