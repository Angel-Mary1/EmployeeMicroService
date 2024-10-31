package Practice.springboot.employe.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
//        registry.addInterceptor( new LogHandlerInterceptor());
//        registry.addInterceptor(new BasicAuthHandlerInterceptor());

        registry.addInterceptor( new LogHandlerInterceptor()).order(2);
        registry.addInterceptor(new BasicAuthHandlerInterceptor()).order(1).addPathPatterns("/api/student");
    }
}
