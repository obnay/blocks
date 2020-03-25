package com.obnay.blocks;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.repository.SysUserRepository;
import com.obnay.block.sys.user.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author taoyanbo
 * @date 2020-03-21 23:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void jpaTest(){

        SysUser user0 = sysUserService.findById("123");

        System.out.println(user0);

        SysUser user = new SysUser().setRealName("1244").setLoginName("12344");
        user = sysUserService.save(user);

        user.setAge((byte )0);

        user = sysUserService.save(user);

        user.setRealName("zzz");

        sysUserService.save(user);

        System.out.println(sysUserRepository.findAll());

    }
}
