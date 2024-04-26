package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spring.common.web.LogonCheckInterceptor;

//===================== ߰ Class  ======================//
// Interceptor ϴ WebMvcCongigurer  Bean
//=======================================================//
@Configuration
public class WebConfig implements WebMvcConfigurer {

	public WebConfig() {
		System.out.println("==> WebConfig default Constructor call.............");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// URL Pattern  Ȯϰ. interceptor  .
		registry.addInterceptor( new LogonCheckInterceptor()).addPathPatterns("/user/*");
		
	}

}
