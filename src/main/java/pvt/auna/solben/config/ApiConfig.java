package pvt.auna.solben.config;

//import org.dozer.DozerBeanMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApiConfig {
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
