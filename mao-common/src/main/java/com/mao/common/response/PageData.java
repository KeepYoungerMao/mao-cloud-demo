package com.mao.common.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页数据包装类
 * create by mzx at 2021/1/30 18:23
 */
@Getter
@Setter
public class PageData<T> {

    private Integer page;           //页码
    private Integer size;           //每页条数
    private Long total;             //数据总条数
    private List<T> dataList;       //数据列表

}
