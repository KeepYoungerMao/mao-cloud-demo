package com.mao.account.entity.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mao.common.entity.Sign;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色数据
 * @author : create by zongx at 2020/11/10 16:37
 */
@Getter
@Setter
public class Role extends Sign {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String code;

    private String name;

    private String intro;

}
