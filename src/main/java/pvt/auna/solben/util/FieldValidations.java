package pvt.auna.solben.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldValidations {

	private final Logger log = LoggerFactory.getLogger(FieldValidations.class);

	public FieldValidations() {
	}

	public boolean isValid(String codScgSolben) {
		log.debug("Starting boolean isValid(), entra a la validacion de COD_SCG_SOLBEN");
		if (codScgSolben.length() <= 20) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidFormat(String op) {
		log.debug("Starting boolean isValid(), entra a lista targetRates y valida amout");
		if (!op.matches("[A-Za-z0-9]")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidHora(String horaScgSolben) {
		log.debug("Starting boolean isValidHora(), entra a la validacion de horaScgSolben");

		Boolean valid = false;
		try {
			String strFormat[] = horaScgSolben.split(":");
			for (String a : strFormat) {
				if (a.length() == 2) {
					valid = true;
				} else {
					valid = false;
					break;
				}
			}
		} catch (Exception e) {
			valid = false;
		}

		return valid;

	}

}
