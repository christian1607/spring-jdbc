package pvt.auna.solben.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class ApiEncoding {


		@Bean
	    public FilterRegistrationBean filterRegistrationBean() {
	        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	        characterEncodingFilter.setEncoding("UTF-8");
	        registrationBean.setFilter(characterEncodingFilter);
	        return registrationBean;
	    }
}
