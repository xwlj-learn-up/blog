package cn.xwlj888.blog.config;

/**
 * @author
 * @create 2018-08-22 13:49
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 错误页面的配置
 * @author zs
 */
@Configuration
@Slf4j
public class ErrorPagesConfig {
    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new MyErrorPageRegistrar();
    }

    private static class MyErrorPageRegistrar implements ErrorPageRegistrar {
        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            System.out.println("HttpStatus.NOT_FOUND:"+HttpStatus.NOT_FOUND+"");
            ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error-400.html");
            ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
            ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-500.html");
            registry.addErrorPages(errorPage400,errorPage404,errorPage500);
        }

    }
}