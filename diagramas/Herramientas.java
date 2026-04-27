package diagramas;

public class Herramientas {

	  protected int codigo;
	    protected String marca;

	    public Herramientas(int codigo, String marca) {
	        this.codigo = codigo;
	        this.marca = marca;
	    }

	    public void usar() {
	        System.out.println("en uso");
	    }

	    public void devolver() {
	        System.out.println("devolviendo");
	    }
	}