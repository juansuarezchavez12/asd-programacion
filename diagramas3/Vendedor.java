package juan4;

import java.util.ArrayList;

public class Vendedor {

    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Vendedor(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
        v.asignarVendedor(this);
    }

    public void mostrarVehiculos() {
        System.out.println("vehiculos de " + nombre + ":");
        for (Vehiculo v : vehiculos) {
            System.out.println("- " + v.getModelo());
        }
    }
}