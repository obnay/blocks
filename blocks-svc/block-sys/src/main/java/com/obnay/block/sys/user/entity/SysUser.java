package com.obnay.block.sys.user.entity;

import com.obnay.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 系统用户表
 *
 * @author taoyanbo
 * @date 2020-03-21 16:36
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    @Column(unique = true, length = 100)
    private String realName;

    /**
     * 登录名
     */
    @Column(unique = true, nullable = false, length = 20)
    private String loginName;

    /**
     * 手机号码
     */
    @Column(unique = true, length = 11)
    private String mobile;

    /**
     * 邮箱
     */
    @Column(unique = true, length = 100)
    private String email;

    /**
     * 性别
     */
    @Column(length = 1)
    private Byte sex;

    /**
     * 年龄
     */
    @Column(length = 3)
    private Byte age;

    /**
     * 密码
     */
    @Column(length = 100)
    private String password;

    /**
     * 加密
     */
    @Column(length = 100)
    private String salt;

    /**
     * 头像
     */
    @Column
    private String avatar;

    /**
     * 状态
     */
    @Column(length = 1)
    private Byte status;
}
