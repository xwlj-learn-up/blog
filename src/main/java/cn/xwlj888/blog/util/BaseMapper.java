package cn.xwlj888.blog.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zs
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {

}