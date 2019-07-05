package pvt.auna.solben.config;



import org.apache.log4j.Logger;

/**
 * Created by acaceres on 20/09/2018.
 */
public class ApiAudit {
    public static final Logger logRtgRoutingRestriction = buildLogger("RoutingRoutingRestriction");
    public static final Logger logRtgDrayMilesRestriction = buildLogger("RoutingDrayMilesRestriction");
    public static final Logger logRtgAutoAccesorial = buildLogger("RoutingAutomatedAccesorial");
    public static final Logger logRtgCustomerMarginFee = buildLogger("RoutingCustomerMarginFee");
    public static final Logger logRtgAssembler = buildLogger("RoutingAssembly");
    public static final Logger logRtgCalc = buildLogger("RoutingCalc");
    public static final Logger logRtgDataLoader = buildLogger("RoutingDataLoader");
    public static final Logger logRtgPersister = buildLogger("RoutingPersister");
    public static final Logger logRtgSummary = buildLogger("RoutingSummary");

    private static Logger buildLogger(String routingRoutingRestriction) {
        return Logger.getLogger(ApiAudit.class.getName() + "." + routingRoutingRestriction);
    }


   
}
