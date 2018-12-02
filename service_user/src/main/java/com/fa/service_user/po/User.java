package com.fa.service_user.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * description:
 * <p>User .<br/></p>
 * <p>
 * change history:
 * date             defect#             person             comments
 * -------------------------------------------------------------------------------------------------------------------
 * 2018/12/2         ********             ZQI               create file
 *
 * @author: ZQI
 * @date: 2018/12/2 11:31
 * @copyright: 2018, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {

    /**
     * 逻辑主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户昵称
     */
    @Column(name = "name",length = 12)
    private String name;

    /**
     * 登陆账号
     */
    @Column(name = "account",length = 20)
    private String account;

    /**
     * 登陆密码
     */
    @Column(name = "password",length = 20)
    private String password;

    /**
     * 性别
     */
    @Column(name = "sex")
    private Boolean sex;

    public User() {
    }

    public User(String name, String account, String password, Boolean sex) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.sex = sex;
    }
}
