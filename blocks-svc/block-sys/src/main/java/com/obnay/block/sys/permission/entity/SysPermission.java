package com.obnay.block.sys.permission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obnay.common.base.BaseAuditorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 权限表
 *
 * @author taoyanbo
 * @date 2020-04-27 11:11
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission extends BaseAuditorEntity {

    private static final long serialVersionUID = 7021206214394826109L;

    @Column(unique = true, length = 100)
    private String permissionName;

    @Column(length = 1)
    private Byte status;

    @Column(length = 1)
    private Byte permissionType;


}
