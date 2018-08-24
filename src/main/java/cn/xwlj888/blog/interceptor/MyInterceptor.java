package cn.xwlj888.blog.interceptor;

/**
 * @author
 * @create 2018-08-22 17:23
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyInterceptor extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(managerInterceptor()).addPathPatterns("/manager/*").excludePathPatterns("/manager/login");
        registry.addInterceptor(errorPageInterceptor());
        super.addInterceptors(registry);
    }

    /**
     * 错误页拦截器
     * @return
     */
    @Bean
    public ErrorPageInterceptor errorPageInterceptor(){
        return  new ErrorPageInterceptor();
    }

    /**
     * 后台管理拦截器
     * @return
     */
    @Bean
    public  ManagerInterceptor managerInterceptor(){
        return  new ManagerInterceptor();
    }
}
