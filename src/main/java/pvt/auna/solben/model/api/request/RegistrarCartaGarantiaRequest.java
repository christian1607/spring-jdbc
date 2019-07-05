package pvt.auna.solben.model.api.request;

import java.util.List;

public class RegistrarCartaGarantiaRequest {

    private List<CargaSCG> listaCargaSCG;

    public List<CargaSCG> getListaCargaSCG() {
        return listaCargaSCG;
    }

    public void setListaCargaSCG(List<CargaSCG> listaCargaSCG) {
        this.listaCargaSCG = listaCargaSCG;
    }
}
