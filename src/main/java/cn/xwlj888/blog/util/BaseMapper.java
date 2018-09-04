package cn.xwlj888.blog.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.select.SelectCountMapper;

/**
 * @author zs
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>,SelectCountMapper<T> {

}