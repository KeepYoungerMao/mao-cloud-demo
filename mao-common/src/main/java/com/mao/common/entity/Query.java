package com.mao.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询参数类
 * 数据查询以此类为基本字段，复杂查询类可继承此类进行扩展
 * create by mzx at 2021/1/30 18:13
 */
@Getter
@Setter
public class Query {

    private QueryType type;     //查询类型
    private String value;       //查询参数值
    private Integer page;       //页码，起始1，默认1
    private Integer size;       //每页条数，默认20

    //计算属性，非查询参数
    private int start;          //分页查询起始值

    /**
     * 分页查询参数的整理
     */
    public void calculate() {
        this.page = null == this.page || this.page < 1 ? 1 : this.page;
        this.size = null == this.size || this.size <= 1 || this.size > 100 ? 20 : this.size;
        this.start = this.page == 1 ? 0 : (this.page - 1) * this.size;
    }

}
