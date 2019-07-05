package pvt.auna.solben.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "configuracionFTP")
public class ConfigFTPProp {
	private String rutaTemp;
	private String rutaFTP;
	private String userApp;

	public String getRutaTemp() {
		return rutaTemp;
	}

	public void setRutaTemp(String rutaTemp) {
		this.rutaTemp = rutaTemp;
	}

	public String getRutaFTP() {
		return rutaFTP;
	}

	public void setRutaFTP(String rutaFTP) {
		this.rutaFTP = rutaFTP;
	}

	public String getUserApp() {
		return userApp;
	}

	public void setUserApp(String userApp) {
		this.userApp = userApp;
	}

}
