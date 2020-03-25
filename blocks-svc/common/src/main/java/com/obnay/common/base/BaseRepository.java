package com.obnay.common.base;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author taoyanbo
 * @date 2020-03-22 00:15
 */
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, String> {

}