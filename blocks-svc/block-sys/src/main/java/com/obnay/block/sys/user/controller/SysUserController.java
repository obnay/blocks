package com.obnay.block.sys.user.controller;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.model.LoginModel;
import com.obnay.block.sys.user.service.SysUserService;
import com.obnay.common.annotation.AutoLog;
import com.obnay.common.base.Result;
import com.obnay.common.constant.LogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taoyanbo
 * @date 2020-03-25 11:05
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @AutoLog(value = "用户查询", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Result<SysUser> queryOne(@PathVariable String id) {
        Result<SysUser> result = new Result<>();
        result.setResult(userService.findById(id));
        return result;
    }

    @AutoLog(value = "用户新增", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysUser> add(@RequestBody SysUser sysUser) {
        Result<SysUser> result = new Result<>();
        result.setResult(userService.save(sysUser));
        return result;
    }

    @AutoLog(value = "用户新增", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody LoginModel loginModel) {
        return userService.login(loginModel);
    }
}
