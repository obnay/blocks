package com.obnay.block.sys.permission.controller;

import com.obnay.block.sys.permission.entity.SysPermission;
import com.obnay.block.sys.permission.service.SysPermissionService;
import com.obnay.block.sys.permission.service.SysRolePermissionService;
import com.obnay.block.sys.permission.service.SysRoleService;
import com.obnay.common.annotation.AutoLog;
import com.obnay.common.base.Result;
import com.obnay.common.constant.LogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taoyanbo
 * @date 2020-04-27 11:17
 */
@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysRolePermissionService rolePermissionService;

    @Autowired
    private SysPermissionService permissionService;

    @AutoLog(value = "新增许可", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<SysPermission> addPermission(@RequestBody SysPermission permission) {
        Result<SysPermission> result = new Result<>();
        result.setResult(permissionService.save(permission));
        return result;
    }

    @AutoLog(value = "修改许可", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<SysPermission> updatePermission(@RequestBody SysPermission permission) {
        Result<SysPermission> result = new Result<>();
        result.setResult(permissionService.update(permission));
        return result;
    }

    @AutoLog(value = "新增许可", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public Result<SysPermission> addRole(@RequestBody SysPermission permission) {
        Result<SysPermission> result = new Result<>();
        result.setResult(permissionService.save(permission));
        return result;
    }

    @AutoLog(value = "修改许可", logType = LogTypeEnum.OP_LOG)
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public Result<SysPermission> updateRole(@RequestBody SysPermission permission) {
        Result<SysPermission> result = new Result<>();
        result.setResult(permissionService.update(permission));
        return result;
    }
}
