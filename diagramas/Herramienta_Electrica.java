package diagramas;

public class Herramienta_Electrica extends Herramientas{
    private int voltaje;

    public Herramienta_Electrica(int codigo, String marca, int voltaje) {
        super(codigo, marca);
        this.voltaje = voltaje;
    }

    public void conectar() {
        System.out.println("La herramienta con código " + codigo + " se está conectando a " + voltaje + " Volts");
    }

    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }
}