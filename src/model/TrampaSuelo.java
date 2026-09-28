package model;

public class TrampaSuelo extends Amenaza {
    private double radioActivacion;
    private boolean visible;

    public TrampaSuelo(Integer id, double posicionX, double posicionY, int danio, double radioActivacion, boolean visible) {
        super(id, posicionX, posicionY, danio);
        this.radioActivacion = radioActivacion;
        this.visible = visible;
    }

    @Override
    public boolean verificarImpacto(double jugadorX, double jugadorY) {
        double distancia = Math.sqrt(Math.pow(this.posicionX - jugadorX, 2) + Math.pow(this.posicionY - jugadorY, 2));
        return distancia <= this.radioActivacion;
    }

    public double getRadioActivacion() { return radioActivacion; }
    public boolean isVisible() { return visible; }
}