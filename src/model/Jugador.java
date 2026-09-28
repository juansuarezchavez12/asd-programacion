package model;

public class Jugador {
    private String nombre;
    private double posicionX;
    private double posicionY;
    private int vidaActual;
    private int vidaMaxima;
    private boolean dashEnCooldown;

    public Jugador(String nombre, double posicionX, double posicionY, int vidaMaxima) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.dashEnCooldown = false;
    }

    public String getNombre() { return nombre; }
    public double getPosicionX() { return posicionX; }
    public void setPosicionX(double posicionX) { this.posicionX = posicionX; }
    public double getPosicionY() { return posicionY; }
    public void setPosicionY(double posicionY) { this.posicionY = posicionY; }
    public int getVidaActual() { return vidaActual; }
    public void recibirDanio(int cantidad) { this.vidaActual = Math.max(0, this.vidaActual - cantidad); }
    public boolean isDashEnCooldown() { return dashEnCooldown; }
    public void setDashEnCooldown(boolean dashEnCooldown) { this.dashEnCooldown = dashEnCooldown; }
}