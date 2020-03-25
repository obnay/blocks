package com.obnay.block.sys.permission;

import com.obnay.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 角色-权限
 *
 * @author taoyanbo
 * @date 2020-03-25 22:43
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRolePermission extends BaseEntity {

    @Column(length = 32)
    private String roleId;

    @Column(length = 100)
    private String resType;

    @Column(length = 32)
    private String resValue;

}
