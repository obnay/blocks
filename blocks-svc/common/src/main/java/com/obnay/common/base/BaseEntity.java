package com.obnay.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础entity
 *
 * @author taoyanbo
 * @date 2020-03-21 16:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@EntityListeners({AuditingEntityListener.class, BaseEntityListener.class})
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * ID-主键
     */
    @Id
    @Column(length = 32)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    @CreatedDate
    private Date createDate;

    /**
     * 修改时间
     */
    @Column
    @LastModifiedDate
    private Date updateDate;

    /**
     * 创建人
     */
    @Column(length = 32, updatable = false)
    @CreatedBy
    private String createBy;

    /**
     * 修改人
     */
    @Column(length = 32)
    @LastModifiedBy
    private String updateBy;
}
