package com.fa.service_order.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * description: Json工具类
 * <p>JsonUtils .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 16:24
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * json字符串转Json对象的方法
     * @param obj
     * @return
     */
    public static JsonNode strToJsonNode(Object obj){
        try {
            String json = OBJECT_MAPPER.writeValueAsString(obj);
            return OBJECT_MAPPER.readTree(json);
        } catch (IOException e) {
            System.out.println("=================== 字符串转换为JsonNode失败========================");
            return null;
        }
    }
}
