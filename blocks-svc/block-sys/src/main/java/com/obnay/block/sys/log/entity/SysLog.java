package com.obnay.block.sys.log.entity;

import com.obnay.common.base.BaseEntity;
import com.obnay.common.constant.LogTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

    private String className;

    private String methodName;

    private String userId;

    private String userName;

    private String logContent;

    @Enumerated(EnumType.ORDINAL)
    private LogTypeEnum logType;

    private String requestParam;

    private String requestMethod;
}
