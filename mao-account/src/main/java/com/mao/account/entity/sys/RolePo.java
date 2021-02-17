package com.mao.account.entity.sys;

import com.mao.account.util.OAuthUtil;
import com.mao.common.ex.InvalidParamException;
import com.mao.common.util.NU;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : create by zongx at 2020/11/18 16:20
 */
@Getter
@Setter
public class RolePo {

    private String id;

    @NotNull
    @Length(min = 1, max = 20)
    private String code;

    @NotNull
    @Length(min = 1, max = 20)
    private String name;

    @Length(max = 200)
    private String intro;

    private List<String> incPermissions;   //需要增加的权限列表
    private List<String> decPermissions;   //需要去掉的权限列表

    /**
     * 新增、更新时，转换为DO数据
     * @param edit 是否为更新，更新时需要主键
     * @return Role
     * @throws InvalidParamException 转换时会抛出校验异常
     */
    public Role format(boolean edit) throws InvalidParamException {
        Role role = new Role();
        if (edit) {
            role.setId(NU.validId(this.id));
        }
        role.setCode(this.code);
        role.setName(this.name);
        role.setIntro(this.intro);
        role.setOperator(OAuthUtil.getOperator());
        return role;
    }

}
