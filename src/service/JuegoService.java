package service;

import dao.AmenazaDAO;
import exceptions.*;
import model.*;
import java.sql.SQLException;

public class JuegoService {
    private AmenazaDAO amenazaDAO;

    public JuegoService() {
        this.amenazaDAO = new AmenazaDAO();
    }

    // Regla 1: Validar que el daño sea mayor a cero
    public void registrarAmenaza(Amenaza amenaza) throws DanioInvalidoException, SQLException {
        if (amenaza.getDanio() <= 0) {
            throw new DanioInvalidoException("El daño de la amenaza debe ser mayor a 0.");
        }
        amenazaDAO.guardar(amenaza);
    }

    // Regla 2: Validar que el jugador no se salga de los límites de la arena (0 a 100)
    public void moverJugador(Jugador jugador, double nuevaX, double nuevaY) throws FueraDeLimitesException {
        if (nuevaX < 0 || nuevaX > 100 || nuevaY < 0 || nuevaY > 100) {
            throw new FueraDeLimitesException("¡Movimiento inválido! El jugador se sale de la arena.");
        }
        jugador.setPosicionX(nuevaX);
        jugador.setPosicionY(nuevaY);
    }

    // Regla 3: Validar enfriamiento (cooldown) de la habilidad de esquive
    public void usarDash(Jugador jugador, double destinoX, double destinoY) throws HabilidadEnCooldownException, FueraDeLimitesException {
        if (jugador.isDashEnCooldown()) {
            throw new HabilidadEnCooldownException("¡El Dash está en enfriamiento! No podés usarlo ahora.");
        }
        moverJugador(jugador, destinoX, destinoY);
        jugador.setDashEnCooldown(true);
    }

    // Regla 4: Buscar oleada/amenaza por ID en la BD
    public Amenaza cargarAmenaza(int id) throws OleadaNoEncontradaException, SQLException {
        Amenaza amenaza = amenazaDAO.obtenerPorId(id);
        if (amenaza == null) {
            throw new OleadaNoEncontradaException("No se encontró ninguna amenaza con ID: " + id);
        }
        return amenaza;
    }

    // Regla 5 + MÉTODO POLIMÓRFICO: Recibe la interfaz Colisionable
    public void procesarImpacto(Colisionable colisionable, Jugador jugador, int danio) throws JugadorEliminadoException {
        if (colisionable.verificarImpacto(jugador.getPosicionX(), jugador.getPosicionY())) {
            jugador.recibirDanio(danio);
            System.out.println("¡IMPACTO DETECTADO! Vida restante de " + jugador.getNombre() + ": " + jugador.getVidaActual());
            if (jugador.getVidaActual() <= 0) {
                throw new JugadorEliminadoException("¡El jugador " + jugador.getNombre() + " ha muerto! Game Over.");
            }
        } else {
            System.out.println("El jugador esquivó el ataque con éxito.");
        }
    }
}