package com.mao.account.mapper.sys;

import com.mao.account.entity.sys.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : create by zongx at 2020/11/13 15:23
 */
@Repository
@Mapper
public interface ClientMapper {

    Client getClientById(@Param("id") Long id);

}
