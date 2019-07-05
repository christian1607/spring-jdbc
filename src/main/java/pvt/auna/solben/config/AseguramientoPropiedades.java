package pvt.auna.solben.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "portalComun")
public class AseguramientoPropiedades {


	private String oauth2;

	public String getOauth2() {
		return oauth2;
	}

	public void setOauth2(String oauth2) {
		this.oauth2 = oauth2;
	}
}
