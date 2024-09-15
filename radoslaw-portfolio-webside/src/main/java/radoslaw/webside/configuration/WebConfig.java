package radoslaw.webside.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the AuthInterceptor to be applied to all endpoints (/**)
        System.out.println("addInterceptors");
        registry.addInterceptor(authInterceptor).addPathPatterns("/auth/test1");
    }
}

