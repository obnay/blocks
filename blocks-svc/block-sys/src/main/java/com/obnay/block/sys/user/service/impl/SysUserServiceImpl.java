package com.obnay.block.sys.user.service.impl;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.repository.SysUserRepository;
import com.obnay.block.sys.user.service.SysUserService;
import com.obnay.common.base.BaseServiceImpl;
import com.obnay.common.event.EntityEvent;
import org.springframework.stereotype.Service;

/**
 * @author taoyanbo
 * @date 2020-03-22 00:54
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserRepository> implements SysUserService {

    @Override
    public void onEntityEvent(EntityEvent event) {
        super.onEntityEvent(event);
    }

    @Override
    public SysUser findByLoginNameOrMobileOrEmail(String loginName) {
        return this.getRepository().findByLoginNameOrMobileOrEmail(loginName);
    }
}
