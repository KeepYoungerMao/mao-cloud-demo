package com.mao.account.entity.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * 权限
 * @author : create by zongx at 2020/11/10 10:40
 */
@Getter
@Setter
public class Permission {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;            //id

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;           //pid

    private String code;        //权限码

    private String name;        //名称

}
