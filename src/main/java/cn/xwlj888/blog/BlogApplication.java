package cn.xwlj888.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zs
 */
@MapperScan(basePackages="cn.xwlj888.blog.mybatis")
@ImportResource(locations={"classpath:mykaptcha.xml"})
@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
