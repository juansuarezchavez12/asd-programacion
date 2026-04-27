package diagramas;

public class Main {

	public static void main(String[] args) {
		  Herramienta_Electrica taladro = new Herramienta_Electrica(1, "multimetro", 100);
	        manual martillo = new manual(2, "martillos nacho", "pena");
	        Herramienta_Electrica soldador = new Herramienta_Electrica(3, "capacitor", 220);
	        manual destornillador = new manual(4, "destornilladores nacho", "mango");
	        manual lima = new manual(5, "limas nacho", "metal");
	        
	        martillo.usar();
	        martillo.devolver();

	        taladro.usar();
	        taladro.devolver();
	        taladro.conectar();
	        
	        soldador.usar();
	        soldador.devolver();
	        soldador.conectar();
	        
	        destornillador.usar();
	        destornillador.devolver();
	        
	        lima.usar();
	        lima.devolver();
	        
	        
	        
	    }
	}