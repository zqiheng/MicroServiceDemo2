package com.fa.service_order.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * description:
 * <p>Order .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:00
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    /**
     * 主键Id，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 购买用户Id（由API接口获取）
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单号:用户id+时间戳
     */
    @Column(name = "order_no", length = 30)
    private String orderNo;

    /**
     * 订单创建时间 new Date();
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy:MM:dd hh:MM:ss")
    @Column(name = "order_create_time")
    private Date createTime;

    /**
     * 订单状态：1：完成、0：未完成
     */
    @Column(name = "order_status")
    private Boolean orderStatus;

    /**
     * 订单表和订单详细表是一对多关系，由订单详细信息类维护
     */
    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(Integer userId, String orderNo, Date createTime, Boolean orderStatus, List<OrderDetails> orderDetails) {
        this.userId = userId;
        this.orderNo = orderNo;
        this.createTime = createTime;
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
    }
}
