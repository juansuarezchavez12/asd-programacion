package juan4;

public class Main {

    public static void main(String[] args) {

        Vendedor v1 = new Vendedor("santiago");
        Vendedor v2 = new Vendedor("juan_carlos");
        Vendedor v3 = new Vendedor("sofia_uribe");

        Vehiculo a1 = new Auto("AIS234", "Toyota");
        Vehiculo a2 = new Auto("B2314S", "Ford");
        Vehiculo m1 = new Moto("CFFAS4", "Ferrari");
        Vehiculo m2 = new Moto("ANOS54", "Kawasaki");
        Vehiculo a3 = new Auto("AF4435", "Chevrolet");
        Vehiculo m3 = new Moto("ADS234", "Audi");
        Vehiculo a4 = new Auto("ASD075", "BMW");
        Vehiculo m4 = new Moto("LFW352", "Fiat");
        Vehiculo a5 = new Auto("PP_232", "Bentley");
        Vehiculo m5 = new Moto("CER379", "Jaguar");

        v1.agregarVehiculo(a1);
        v1.agregarVehiculo(m1);
        v1.agregarVehiculo(a2);

        v2.agregarVehiculo(m2);
        v2.agregarVehiculo(a3);
        v2.agregarVehiculo(m3);

        v3.agregarVehiculo(a4);
        v3.agregarVehiculo(m4);
        v3.agregarVehiculo(a5);
        v3.agregarVehiculo(m5);

        v1.mostrarVehiculos();
        v2.mostrarVehiculos();
        v3.mostrarVehiculos();
    }
}




