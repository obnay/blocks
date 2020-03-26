package com.obnay.block.sys.user.repository;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.common.base.BaseRepository;

/**
 * @author taoyanbo
 * @date 2020-03-21 23:49
 */
public interface SysUserRepository extends BaseRepository<SysUser> {

    /**
     * 根据账号查找
     *
     * @param loginName
     * @param mobile
     * @return
     */
    SysUser findByLoginNameOrMobile(String loginName, String mobile);
}
