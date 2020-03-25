package com.obnay.block.sys.user.controller;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.service.SysUserService;
import com.obnay.common.annotation.AutoLog;
import com.obnay.common.base.Result;
import com.obnay.common.constant.LogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taoyanbo
 * @date 2020-03-25 11:05
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @AutoLog(value = "用户查询", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Result<SysUser> queryOne(@PathVariable String id) {
        Result<SysUser> result = new Result<>();
        result.setResult(sysUserService.findById(id));
        return result;
    }
}
