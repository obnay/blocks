package com.obnay.block.sys.permission.entity;

import com.obnay.common.base.BaseAuditorEntity;
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
public class SysRolePermission extends BaseAuditorEntity {

    @Column(length = 32)
    private String roleId;

    @Column(length = 100)
    private String resType;

    @Column(length = 32)
    private String resValue;

}
