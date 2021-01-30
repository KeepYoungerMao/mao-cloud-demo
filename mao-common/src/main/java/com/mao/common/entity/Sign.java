package com.mao.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 标识类
 * 约定数据库映射类需继承此类，数据库字段应设置这些基础字段
 * create by mzx at 2021/1/29 22:38
 */
@Getter
@Setter
public class Sign {

    private Long create;            //创建时间
    private String creator;         //创建人
    private Boolean del;            //删除标识
    private Long update;            //上次更新时间
    private String updater;         //上次更新人

    /**
     * 设置操作者信息，设置本类标识信息
     * @param operator SecurityContextHolder中获得本次请求的账户
     */
    public void setOperator(Operator operator) {
        long now = System.currentTimeMillis();
        this.create = now;
        this.creator = operator.getUser();
        this.del = false;
        this.update = now;
        this.updater = operator.getUser();
    }

}
