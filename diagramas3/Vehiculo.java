package juan4;

public abstract class Vehiculo {

    private String patente;
    private String modelo;
    protected Vendedor vendedor;

    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
    }

    public void asignarVendedor(Vendedor v) {
        this.vendedor = v;
    }

    public String getModelo() {
        return modelo;
    }
}