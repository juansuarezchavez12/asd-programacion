import exceptions.*;
import model.*;
import service.JuegoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO LOL DODGE TRAINER ===");
        JuegoService service = new JuegoService();
        Jugador yasuo = new Jugador("Yasuo", 50.0, 50.0, 100);

        // 1. Guardar en BD MySQL a través del DAO
        System.out.println("\n--- TEST 1: Guardando Amenazas en MySQL ---");
        try {
            Amenaza qEzreal = new ProyectilLineal(null, 50.0, 50.0, 30, 15.0, 90.0);
            Amenaza hongoTeemo = new TrampaSuelo(null, 20.0, 20.0, 50, 2.0, true);

            service.registrarAmenaza(qEzreal);
            service.registrarAmenaza(hongoTeemo);

            System.out.println("-> Proyectil guardado en BD con ID: " + qEzreal.getId());
            System.out.println("-> Trampa guardada en BD con ID: " + hongoTeemo.getId());
        } catch (Exception e) {
            System.out.println("[Nota BD]: Si no tenés MySQL encendido, la prueba de BD fallará aquí: " + e.getMessage());
        }

        // 2. Uso Polimórfico de la Interfaz
        System.out.println("\n--- TEST 2: Prueba Polimórfica de Colisión ---");
        try {
            Colisionable proyectil = new ProyectilLineal(1, 50.0, 50.0, 25, 10.0, 0.0);
            service.procesarImpacto(proyectil, yasuo, 25);
        } catch (JugadorEliminadoException e) {
            System.out.println("[Excepción Capturada]: " + e.getMessage());
        }

        // 3. Forzando las 5 Excepciones Personalizadas
        System.out.println("\n--- TEST 3: Provocando y Capturando las 5 Excepciones ---");

        // Excepción 1: DanioInvalidoException
        try {
            System.out.print("[Prueba 1] Registrando daño inválido (0)... ");
            service.registrarAmenaza(new ProyectilLineal(null, 10.0, 10.0, 0, 5.0, 0.0));
        } catch (DanioInvalidoException e) {
            System.out.println("CAPTURADA CONTROLADAMENTE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }

        // Excepción 2: FueraDeLimitesException
        try {
            System.out.print("[Prueba 2] Moviendo jugador fuera de la arena (X=150)... ");
            service.moverJugador(yasuo, 150.0, 50.0);
        } catch (FueraDeLimitesException e) {
            System.out.println("CAPTURADA CONTROLADAMENTE: " + e.getMessage());
        }

        // Excepción 3: HabilidadEnCooldownException
        try {
            System.out.print("[Prueba 3] Forzando uso de Dash en Cooldown... ");
            yasuo.setDashEnCooldown(true);
            service.usarDash(yasuo, 55.0, 55.0);
        } catch (HabilidadEnCooldownException e) {
            System.out.println("CAPTURADA CONTROLADAMENTE: " + e.getMessage());
        } catch (FueraDeLimitesException e) {
            System.out.println("Error de límites: " + e.getMessage());
        }

        // Excepción 4: OleadaNoEncontradaException
        try {
            System.out.print("[Prueba 4] Buscando ID inexistente en la BD (ID=99999)... ");
            service.cargarAmenaza(99999);
        } catch (OleadaNoEncontradaException e) {
            System.out.println("CAPTURADA CONTROLADAMENTE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de conexión MySQL: " + e.getMessage());
        }

        // Excepción 5: JugadorEliminadoException
        try {
            System.out.print("[Prueba 5] Asestando daño letal al jugador... ");
            Colisionable trampaMortal = new TrampaSuelo(99, yasuo.getPosicionX(), yasuo.getPosicionY(), 200, 5.0, true);
            service.procesarImpacto(trampaMortal, yasuo, 200);
        } catch (JugadorEliminadoException e) {
            System.out.println("CAPTURADA CONTROLADAMENTE: " + e.getMessage());
        }

        System.out.println("\n=== EJECUCIÓN FINALIZADA EXITOSAMENTE SIN ERRORES NO CONTROLADOS ===");
    }
}