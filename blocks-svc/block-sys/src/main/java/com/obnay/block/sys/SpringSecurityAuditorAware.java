package com.obnay.block.sys;

import com.obnay.block.sys.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * AuditorAware
 *
 * @author taoyanbo
 * @date 2020-03-26 11:13
 */
@Component
@Slf4j
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    /**
     * 匿名用户
     */
    private static final String ANONYMOUS_USER = "anonymous";

    @Override
    public Optional<String> getCurrentAuditor() {
        SysUser currentUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (currentUser != null) {
            return Optional.of(currentUser.getId());
        } else {
            return Optional.of(ANONYMOUS_USER);
        }
    }
}
