package com.fa.service_product.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * description:
 * <p>Product .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:47
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Product implements Serializable {

    /**
     * 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品名称
     */
    @Column(name = "name",length = 20,nullable = false)
    private String name;

    /**
     * 商品价格
     */
    @Column(name = "price",nullable = false)
    private Float price;

    /**
     * 商品库存
     */
    @Column(name = "stocks")
    private Integer stocks;

    public Product() {
    }
    public Product(String name, Float price, Integer stocks) {
        this.name = name;
        this.price = price;
        this.stocks = stocks;
    }
}