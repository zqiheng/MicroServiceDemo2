package com.fa.service_order.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * description:
 * <p>OrderDetails .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:17
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Entity
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetails implements Serializable {

    /**
     * 主键Id，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单详细类和订单是多对一关系（一个订单包含多个订单信息信息），其关系由订单详细类维护（多的一方维护）
     * 所属订单，外键，关联Order表的主键id
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * 商品Id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品数量
     */
    @Column(name = "product_num")
    private Integer productNum;

    /**
     * 商品单价
     */
    @Column(name = "product_price")
    private Float productPrice;

    public OrderDetails() {
    }

    public OrderDetails(Order order, Integer productId, String productName, Integer productNum, Float productPrice) {
        this.order = order;
        this.productId = productId;
        this.productName = productName;
        this.productNum = productNum;
        this.productPrice = productPrice;
    }
}
