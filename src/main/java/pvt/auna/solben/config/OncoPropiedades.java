package pvt.auna.solben.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "oncosys")
public class OncoPropiedades {
	String oncoAfiliado;
	String oncoMedico;
	String oncoGenerico;
	String oncoDiagnostico;

	public String getOncoAfiliado() {
		return oncoAfiliado;
	}

	public void setOncoAfiliado(String oncoAfiliado) {
		this.oncoAfiliado = oncoAfiliado;
	}

	public String getOncoMedico() {
		return oncoMedico;
	}

	public void setOncoMedico(String oncoMedico) {
		this.oncoMedico = oncoMedico;
	}

	public String getOncoGenerico() {
		return oncoGenerico;
	}

	public void setOncoGenerico(String oncoGenerico) {
		this.oncoGenerico = oncoGenerico;
	}

	public String getOncoDiagnostico() {
		return oncoDiagnostico;
	}

	public void setOncoDiagnostico(String oncoDiagnostico) {
		this.oncoDiagnostico = oncoDiagnostico;
	}

}
