package com.mao.account.entity.sys.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用户新增更新参数
 * @author : create by zongx at 2020/11/18 10:09
 */
@Getter
@Setter
public class UserPo {
    private String id;              //id
    @NotNull
    @Length(min = 2, max = 20)
    private String username;        //登录名
    @NotNull
    @Length(min = 4, max = 16)
    private String password;        //密码
    @NotNull
    private Boolean expired;        //是否过期
    @NotNull
    private Boolean locked;         //是否锁定
    @NotNull
    private Boolean enabled;        //是否可使用
    @NotNull
    private String client;          //客户端名称
    @NotNull
    private String role;            //角色id
    @NotNull
    private String avatar;          //头像

}
