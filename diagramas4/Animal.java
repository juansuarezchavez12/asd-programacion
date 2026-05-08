package juan4;

public abstract class Animal {

    private String nombre;
    private String fechaNacimiento;
    protected Veterinario veterinario;

    public Animal(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void asignarVeterinario(Veterinario v) {
        this.veterinario = v;
    }

    public String getNombre() {
        return nombre;
    }
}