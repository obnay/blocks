package com.obnay.block.sys.role.entity;

import com.obnay.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 角色
 *
 * @author taoyanbo
 * @date 2020-03-25 17:23
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRole extends BaseEntity {

    /**
     * 角色名称
     */
    @Column(unique = true, length = 40)
    private String roleName;

    /**
     * 角色编码
     */
    @Column(unique = true, length = 20)
    private String roleCode;

    /**
     * 角色描述
     */
    @Column
    private String roleDesc;

}
