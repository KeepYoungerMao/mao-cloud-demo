package com.mao.account.entity.sys;

import com.mao.account.util.OAuthUtil;
import com.mao.common.ex.InvalidParamException;
import com.mao.common.util.NU;
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
    private String clientId;          //客户端名称

    @NotNull
    private String roleId;            //角色id

    @NotNull
    private String avatar;          //头像

    /**
     * 新增、更新时，转换为DO数据
     * @param edit 是否为更新，更新时需要主键
     * @return User
     * @throws InvalidParamException 转换时会抛出校验异常
     */
    public User format(boolean edit) throws InvalidParamException {
        User user = new User();
        if (edit) {
            user.setId(NU.validId(this.id));
        }
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setExpired(this.expired);
        user.setLocked(this.locked);
        user.setEnabled(this.enabled);
        Long clientLongId = NU.parseId(this.clientId);
        if (NU.isNotZs(clientLongId)) {
            throw new InvalidParamException("非法客户端标识");
        }
        user.setClient(clientLongId);
        Long roleLongId = NU.parseId(this.roleId);
        if (NU.isNotZs(roleLongId)) {
            throw new InvalidParamException("非法角色标识");
        }
        user.setRole(roleLongId);
        user.setOperator(OAuthUtil.getOperator());
        return user;
    }

}
