package com.fa.service_product.service.impl;

import com.fa.service_product.dao.ProductDao;
import com.fa.service_product.po.Product;
import com.fa.service_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * description:
 * <p>ProductServiceImpl .<br/></p>
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
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getPorductList() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getOne(id);
    }

    @Override
    public Product addProductInfo(Product product) {
        return productDao.save(product);
    }
}
