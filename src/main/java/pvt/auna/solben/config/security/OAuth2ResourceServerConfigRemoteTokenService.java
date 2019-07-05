package pvt.auna.solben.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import pvt.auna.solben.config.AseguramientoPropiedades;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfigRemoteTokenService extends ResourceServerConfigurerAdapter {

	public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
	public static final String TOKEN_EXCLUDE_REST_PUB = "/pub/*";
	
	@Autowired
	private AseguramientoPropiedades aseProp;
	
    @Override
    public void configure(final HttpSecurity http) throws Exception {
    	// @formatter:off
    			/*
    			 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
    			 * IF_REQUIRED) .and() .authorizeRequests().anyRequest().permitAll();
    			 */
    			// @formatter:on
    			// @formatter:off
    			http.csrf().disable() // We don't need CSRF for JWT based authentication
    					.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
    					.and().authorizeRequests().antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT)
    					.access("#oauth2.hasScope('read') and #oauth2.hasScope('write')") // Protected API End-points
    					.antMatchers(TOKEN_EXCLUDE_REST_PUB).permitAll().anyRequest().permitAll();
    	// @formatter:on        
    }

    @Primary
    @Bean
    public RemoteTokenServices tokenServices() {
        //TODO: Cambiar datos de CLIENT OAUTH
        final RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(aseProp.getOauth2() + "/check_token");
        tokenService.setClientId("ppa-farmacia-compleja-app");
        tokenService.setClientSecret("B95B75295F3D3E2296A3DA02AC8EF932ED33B7CC47727D74F0B02004330AAA87");

        return tokenService;
    }

}
