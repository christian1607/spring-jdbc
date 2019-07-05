package pvt.auna.solben.util;

public class SolbenException extends Exception {

    private String codResponse;

    public SolbenException(String message, String codResponse) {
        super(message);
        this.codResponse = codResponse;
    }

    public String getCodResponse() {
        return codResponse;
    }

    public void setCodResponse(String codResponse) {
        this.codResponse = codResponse;
    }
}
