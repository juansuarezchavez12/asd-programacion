package diagramas2;

import java.util.ArrayList;

public class Socio {

    private String nombre;
    private int nroSocio;
    private ArrayList<libro> libros;

    public Socio(String nombre, int nroSocio) {
        this.nombre = nombre;
        this.nroSocio = nroSocio;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(libro libro) {
        if (libros.size() < 3) {
            libros.add(libro);
            libro.prestar(this);
        } else {
            System.out.println("No se puede tener 3 libros o mas");
        }
    }

    public void mostrarLibros() {
        System.out.println("Libros de " + nombre + ":");
        for (libro l : libros) {
            System.out.println("- " + l.getTitulo());
        }
    }
}