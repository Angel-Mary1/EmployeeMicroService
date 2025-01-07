package Practice.springboot.employe.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Regeistration of interceptor done using WebMvcConfigurer
@Configuration
public class WebMvcConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor( new LogHandlerInterceptor());
//        registry.addInterceptor(new BasicAuthHandlerInterceptor());

        //adding Interceptor & createing a object of the interceptor
        //oreder will decide which interceptor have to run first

//        registry.addInterceptor( new LogHandlerInterceptor()).order(2);
//        registry.addInterceptor(new BasicAuthHandlerInterceptor()).order(1);

        //for particular end point hit use addPathPatterns

//        registry.addInterceptor(new BasicAuthHandlerInterceptor()).order(1).addPathPatterns("/api/student");
    }
}
