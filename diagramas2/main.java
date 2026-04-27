package diagramas2;

public class main {

    public static void main(String[] args) {

        Socio s1 = new Socio("nachito", 1);
        Socio s2 = new Socio("alesi", 2);
        Socio s3 = new Socio("octaavio", 3);

        libro l1 = new libro("1", "jansel y gretel");
        libro l2 = new libro("2", "los dueños");
        libro l3 = new libro("3", "sasha y bruno");
        libro l4 = new libro("4", "la historia");
        libro l5 = new libro("5", "el telefono de satanas");

        s1.agregarLibro(l1);
        s1.agregarLibro(l2);
        s2.agregarLibro(l3);
        s3.agregarLibro(l4);
        s3.agregarLibro(l5);

        s1.mostrarLibros();
        s2.mostrarLibros();
        s3.mostrarLibros();
    }
}