package model;

public class AtaqueArea extends Amenaza {
    private int tiempoDetonacion;
    private double radioImpacto;

    public AtaqueArea(Integer id, double posicionX, double posicionY, int danio, int tiempoDetonacion, double radioImpacto) {
        super(id, posicionX, posicionY, danio);
        this.tiempoDetonacion = tiempoDetonacion;
        this.radioImpacto = radioImpacto;
    }

    @Override
    public boolean verificarImpacto(double jugadorX, double jugadorY) {
        if (tiempoDetonacion > 0) return false;
        double distancia = Math.sqrt(Math.pow(this.posicionX - jugadorX, 2) + Math.pow(this.posicionY - jugadorY, 2));
        return distancia <= this.radioImpacto;
    }

    public int getTiempoDetonacion() { return tiempoDetonacion; }
    public double getRadioImpacto() { return radioImpacto; }
}