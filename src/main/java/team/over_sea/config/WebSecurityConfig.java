package team.over_sea.config;

import team.over_sea.handle.RedisSessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * session身份验证拦截器
 * @author Patrick_Star
 * @version 1.0
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    /**
     * 不需要进行session检测的接口过滤常量
     */
    private final String[] IGNORE_URI = {"/user/wechat/register", "/user/wechat/login", "/user/login"};

    /**
     * redis储存方案的session拦截器
     */
    @Autowired
    RedisSessionInterceptor redisSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(redisSessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(IGNORE_URI);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
