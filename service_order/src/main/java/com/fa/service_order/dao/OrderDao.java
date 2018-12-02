package com.fa.service_order.dao;

import com.fa.service_order.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 * <p>OrderDao .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:35
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface OrderDao extends JpaRepository<Order,Integer> {
}
