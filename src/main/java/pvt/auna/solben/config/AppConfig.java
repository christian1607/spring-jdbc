package pvt.auna.solben.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.annotation.PostConstruct;
import javax.net.ssl.*;
import javax.sql.DataSource;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class AppConfig {
	
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);



	@Bean
	public Boolean disableSSLValidation() throws Exception {
		final SSLContext sslContext = SSLContext.getInstance("TLS");

		sslContext.init(null, new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		} }, null);

		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});

		return true;
	}

	@PostConstruct
	public void init() {
		try {
			TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
			log.info("Timezone configurada es: " + TimeZone.getDefault().getDisplayName());
			log.info("Fecha Actual: " + new Date().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@EventListener(AppConfig.class)
	public void doSomethingAfterStartup() {

	}


	@Bean(name = "fcomplejaDataSource")
	@ConfigurationProperties(prefix = "auna.fcompleja.datasource")
	@Primary
	public DataSource fcomplejaDataSource() {
		return DataSourceBuilder.create()
				.build();
	}

	@Bean(name = "concurrenciaDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource concurrenciaDataSource() {
		return DataSourceBuilder.create()
				.build();
	}

	/*@Bean(name = "concurrenciaDataSource")

	//@ConfigurationProperties(prefix="spring.datasource")
	public DataSource concurrenciaDataSource() {
		return lookup.getDataSource(concurrenciaJndiName);
	}

	@Primary
	@Bean(name = "fcomplejaDataSource")
	//@ConfigurationProperties(prefix="auna.fcompleja.datasource")
	public DataSource fcomplejaDataSource() {
		return lookup.getDataSource(fcomplejaJndiName);
	}*/
}
