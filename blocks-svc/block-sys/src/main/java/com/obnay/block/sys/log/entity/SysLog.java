package com.obnay.block.sys.log.entity;

import com.obnay.common.base.BaseEntity;
import com.obnay.common.constant.LogTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @author taoyanbo
 * @date 2020-03-26 09:42
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysLog extends BaseEntity {

    private long costTime;

    private String ip;

    private Date requestTime;

    @Column(length = 200)
    private String className;

    @Column(length = 100)
    private String methodName;

    @Column(length = 32)
    private String userId;

    @Column(length = 100)
    private String userName;

    private String logContent;

    @Enumerated(EnumType.ORDINAL)
    private LogTypeEnum logType;

    private String requestParam;

    @Column(length = 10)
    private String requestMethod;
}
