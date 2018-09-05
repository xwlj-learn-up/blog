package cn.xwlj888.blog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author
 * @create 2018-09-05 20:30
 **/
@Configuration
public class MyInterceptor implements WebMvcConfigurer {

    @Autowired
    public ErrorPageInterceptor errorPageInterceptor;
    @Autowired
    public ManagerInterceptor managerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(managerInterceptor).addPathPatterns("/manager/*").excludePathPatterns("/manager/login");
        registry.addInterceptor(errorPageInterceptor);
    }


    /**
     * 解决中文乱码
     *
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}
