package diagramas;

public class manual extends Herramientas{
	private String tipoEmpuñadura;

    public manual(int codigo, String marca, String tipoEmpuñadura) {
        super(codigo, marca);
        this.tipoEmpuñadura = tipoEmpuñadura;
    }

    public String getTipoEmpuñadura() {
        return tipoEmpuñadura;
    }

    public void setTipoEmpuñadura(String tipoEmpuñadura) {
        this.tipoEmpuñadura = tipoEmpuñadura;
    }
}

