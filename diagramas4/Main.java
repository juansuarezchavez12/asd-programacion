package main;

public class Main {

    public static void main(String[] args) {
        Veterinario vet1 = new Veterinario("santiago");
        Veterinario vet2 = new Veterinario("juan_carlos");
        Veterinario vet3 = new Veterinario("octavia");
        Animal comun = new Perro("marika", "1/1/20");
        Animal a1 = new Gato("rutila", "9/2/19");
        Animal a2 = new Perro("toto", "1/1/20");
        Animal a3 = new Gato("loki", "7/4/25");
        Animal a4 = new Perro("tulio", "2/6/22");
        vet1.agregarAnimal(comun);
        vet1.agregarAnimal(a1);
        vet2.agregarAnimal(comun);
        vet2.agregarAnimal(a2);
        vet3.agregarAnimal(comun);
        vet3.agregarAnimal(a3);
        vet3.agregarAnimal(a4);
        vet1.mostrarAnimales();
        vet2.mostrarAnimales();
        vet3.mostrarAnimales();
    }
}
