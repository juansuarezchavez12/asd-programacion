package model;

public abstract class Amenaza implements Colisionable {
    protected Integer id;
    protected double posicionX;
    protected double posicionY;
    protected int danio;

    public Amenaza(Integer id, double posicionX, double posicionY, int danio) {
        this.id = id;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.danio = danio;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public double getPosicionX() { return posicionX; }
    public double getPosicionY() { return posicionY; }
    public int getDanio() { return danio; }
}