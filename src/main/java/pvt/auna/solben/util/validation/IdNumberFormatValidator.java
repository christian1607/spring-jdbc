//package pvt.auna.fcompleja.util.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import org.apache.log4j.Logger;
//import pvt.auna.fcompleja.model.api.request.SolicitudPreliminarRequest;
//
//public class IdNumberFormatValidator implements
//        ConstraintValidator<IdNumberFormatValid, SolicitudPreliminarRequest> {
//
//
//    private final Logger LOGGER = Logger.getLogger(getClass());
//
//    @Override
//    public void initialize(IdNumberFormatValid constraintAnnotation) {
//        //Do nothing
//    }
//
//    @Override
//    public boolean isValid(SolicitudPreliminarRequest request,
//                           ConstraintValidatorContext constraintValidatorContext) {
//        LOGGER.info("Starting boolean isValid(), entra a la validacion de COD_SCG_SOLBEN");
//        String codScgSolben = request.getCod_scg_solben();
//        // if (idc != null) {
//        if (codScgSolben.length() == 20) {
//            //if (idc.matches("^[a-zA-Z0-9\\s-]+$")) {
//                return true;
//            //}
//        }
//        return false;
//    }
//}
