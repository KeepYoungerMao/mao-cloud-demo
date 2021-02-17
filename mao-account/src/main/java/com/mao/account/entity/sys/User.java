package com.mao.account.entity.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mao.common.entity.Sign;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * 用户 sys_user
 * 实现OAuth2
 * @author : create by zongx at 2020/11/10 10:28
 */
@Getter
@Setter
@ToString
public class User extends Sign implements UserDetails, Serializable {

    private static final long serialVersionUID = 12345467890L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;                //id

    private String username;        //登录名

    private String password;        //密码

    private Boolean expired;        //是否过期

    private Boolean locked;         //是否锁定

    private Boolean enabled;        //是否可使用

    @JsonProperty("clientId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long client;          //客户端id

    private String clientName;

    @JsonProperty("roleId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long role;            //角色id

    private String roleName;

    private String avatar;          //头像

    private List<GrantedAuthority> authorities;     //权限列表

    @Override
    public boolean isAccountNonExpired() {
        return !this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.expired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
