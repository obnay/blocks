package com.obnay.block.sys.menu.entity;

import com.obnay.common.base.BaseAuditorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

/**
 * @author taoyanbo
 * @date 2020-04-26 20:03
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu extends BaseAuditorEntity {

    private static final long serialVersionUID = 1L;

    private String menuName;

    private String uriPath;

    private String component;

    private String icon;

    private String parentId;

    private int menuType;

    private int status;

}
