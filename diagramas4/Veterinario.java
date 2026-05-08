package juan4;

import java.util.ArrayList;

public class Veterinario {
    private String nombre;
    private ArrayList<Animal> animales;
    public Veterinario(String nombre) {
        this.nombre = nombre;
        this.animales = new ArrayList<>();
    }
    public void agregarAnimal(Animal a) {
        animales.add(a);
        a.asignarVeterinario(this);
    }
    public void mostrarAnimales() {
        System.out.println("animales de " + nombre + ":");
        for (Animal a : animales) {
            System.out.println("- " + a.getNombre());
        }
    }
}