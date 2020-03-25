package com.obnay.blocks;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.common.constant.EntityEventEnum;
import com.obnay.common.event.EntityEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author taoyanbo
 * @date 2020-03-23 16:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTest {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void eventPublish() {
        SysUser user = new SysUser().setRealName("12").setLoginName("123");
        EntityEvent entityEvent = new EntityEvent(this, user, EntityEventEnum.POST_UPDATE);
        eventPublisher.publishEvent(entityEvent);
    }
}
