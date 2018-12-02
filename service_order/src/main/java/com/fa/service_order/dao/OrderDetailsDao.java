package com.fa.service_order.dao;

import com.fa.service_order.po.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 * <p>OrderDetailsDao .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 12:36
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public interface OrderDetailsDao extends JpaRepository<OrderDetails,Integer> {
}
