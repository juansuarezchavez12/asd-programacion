package model;

public class MuroProyectiles extends Amenaza {
    private double anchoMuro;

    public MuroProyectiles(Integer id, double posicionX, double posicionY, int danio, double anchoMuro) {
        super(id, posicionX, posicionY, danio);
        this.anchoMuro = anchoMuro;
    }

    @Override
    public boolean verificarImpacto(double jugadorX, double jugadorY) {
        boolean enRangoY = Math.abs(this.posicionY - jugadorY) < 1.0;
        boolean enRangoX = jugadorX >= this.posicionX && jugadorX <= (this.posicionX + this.anchoMuro);
        return enRangoY && enRangoX;
    }

    public double getAnchoMuro() { return anchoMuro; }
}