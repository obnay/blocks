package com.obnay.blocks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application
 *
 * @author taoyanbo
 * @date 2020-03-21 14:18
 */

@Slf4j
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.obnay"})
@EntityScan(basePackages = {"com.obnay.block"})
@EnableJpaRepositories(basePackages = {"com.obnay.block"})
@SpringBootApplication
public class BlocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlocksApplication.class, args);
    }
}
