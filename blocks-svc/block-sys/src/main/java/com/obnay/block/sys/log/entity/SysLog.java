package com.obnay.block.sys.log.entity;

import com.obnay.common.base.BaseEntity;
import com.obnay.common.constant.LogTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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

    /**
     * 耗时
     */
    private long costTime;

    /**
     * 客户端IP
     */
    @Column(length = 20)
    private String ipAddress;

    /**
     * 请求时间
     */
    private Date requestTime;

    /**
     * 类名
     */
    @Column(length = 200)
    private String className;

    /**
     * 方法名
     */
    @Column(length = 100)
    private String methodName;

    /**
     * 用户ID
     */
    @Column(length = 32)
    private String userId;

    /**
     * 日志说明
     */
    @Column(length = 100)
    private String logContent;

    /**
     * 日志类型
     */
    @Enumerated(EnumType.ORDINAL)
    private LogTypeEnum logType;

    /**
     * 请求参数
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String requestParam;

    /**
     * 请求方法
     */
    @Column(length = 20)
    private String requestMethod;
}
