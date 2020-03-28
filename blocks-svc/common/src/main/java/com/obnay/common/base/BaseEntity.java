package com.obnay.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
