package com.obnay.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础entity(创建人｜修改人)
 *
 * @author taoyanbo
 * @date 2020-03-21 16:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@MappedSuperclass
public class BaseAuditorEntity extends BaseEntity implements Serializable {

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

    /**
     * 修改时间
     */
    @Column
    @LastModifiedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
}
