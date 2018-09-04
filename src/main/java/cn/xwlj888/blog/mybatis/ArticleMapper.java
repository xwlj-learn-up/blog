package cn.xwlj888.blog.mybatis;

import cn.xwlj888.blog.pojo.Article;
import cn.xwlj888.blog.util.BaseMapper;

/**
 * @author zs
 */
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 数量
     * @return
     */
    Integer getCount();
}