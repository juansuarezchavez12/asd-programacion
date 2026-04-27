package diagramas;

public class libro {

    private String isbn;
    private String titulo;
    private Socio socio; 

    public libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public void prestar(Socio socio) {
        this.socio = socio;
    }

    public String getTitulo() {
        return titulo;
    }
}