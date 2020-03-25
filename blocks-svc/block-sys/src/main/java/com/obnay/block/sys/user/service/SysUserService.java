package com.obnay.block.sys.user.service;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.common.base.BaseService;

/**
 * @author taoyanbo
 * @date 2020-03-22 00:53
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 根据账号查找
     *
     * @param loginName
     * @return
     */
    SysUser findByLoginNameOrMobileOrEmail(String loginName);
}
