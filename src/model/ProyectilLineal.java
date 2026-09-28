package model;

public class ProyectilLineal extends Amenaza {
    private double velocidad;
    private double anguloDireccion;

    public ProyectilLineal(Integer id, double posicionX, double posicionY, int danio, double velocidad, double anguloDireccion) {
        super(id, posicionX, posicionY, danio);
        this.velocidad = velocidad;
        this.anguloDireccion = anguloDireccion;
    }

    @Override
    public boolean verificarImpacto(double jugadorX, double jugadorY) {
        double distancia = Math.sqrt(Math.pow(this.posicionX - jugadorX, 2) + Math.pow(this.posicionY - jugadorY, 2));
        return distancia < 1.5;
    }

    public double getVelocidad() { return velocidad; }
    public double getAnguloDireccion() { return anguloDireccion; }
}