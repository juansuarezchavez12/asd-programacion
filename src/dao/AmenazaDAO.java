package dao;

import model.*;
import java.sql.*;

public class AmenazaDAO {

    public void guardar(Amenaza amenaza) throws SQLException {
        String sql = "INSERT INTO oleadas_amenazas (tipo_amenaza, posicion_x, posicion_y, danio, velocidad, angulo_direccion, radio_impacto, tiempo_detonacion, ancho_muro) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setDouble(2, amenaza.getPosicionX());
            stmt.setDouble(3, amenaza.getPosicionY());
            stmt.setInt(4, amenaza.getDanio());

            // Limpiamos valores por defecto como NULL
            stmt.setNull(5, Types.DECIMAL);
            stmt.setNull(6, Types.DECIMAL);
            stmt.setNull(7, Types.DECIMAL);
            stmt.setNull(8, Types.INTEGER);
            stmt.setNull(9, Types.DECIMAL);

            if (amenaza instanceof ProyectilLineal) {
                ProyectilLineal p = (ProyectilLineal) amenaza;
                stmt.setString(1, "PROYECTIL_LINEAL");
                stmt.setDouble(5, p.getVelocidad());
                stmt.setDouble(6, p.getAnguloDireccion());
            } else if (amenaza instanceof TrampaSuelo) {
                TrampaSuelo t = (TrampaSuelo) amenaza;
                stmt.setString(1, "TRAMPA_SUELO");
                stmt.setDouble(7, t.getRadioActivacion());
            } else if (amenaza instanceof AtaqueArea) {
                AtaqueArea a = (AtaqueArea) amenaza;
                stmt.setString(1, "ATAQUE_AREA");
                stmt.setDouble(7, a.getRadioImpacto());
                stmt.setInt(8, a.getTiempoDetonacion());
            } else if (amenaza instanceof MuroProyectiles) {
                MuroProyectiles m = (MuroProyectiles) amenaza;
                stmt.setString(1, "MURO_PROYECTILES");
                stmt.setDouble(9, m.getAnchoMuro());
            }

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    amenaza.setId(rs.getInt(1));
                }
            }
        }
    }

    public Amenaza obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM oleadas_amenazas WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("tipo_amenaza");
                    double x = rs.getDouble("posicion_x");
                    double y = rs.getDouble("posicion_y");
                    int danio = rs.getInt("danio");

                    switch (tipo) {
                        case "PROYECTIL_LINEAL":
                            return new ProyectilLineal(id, x, y, danio, rs.getDouble("velocidad"), rs.getDouble("angulo_direccion"));
                        case "TRAMPA_SUELO":
                            return new TrampaSuelo(id, x, y, danio, rs.getDouble("radio_impacto"), true);
                        case "ATAQUE_AREA":
                            return new AtaqueArea(id, x, y, danio, rs.getInt("tiempo_detonacion"), rs.getDouble("radio_impacto"));
                        case "MURO_PROYECTILES":
                            return new MuroProyectiles(id, x, y, danio, rs.getDouble("ancho_muro"));
                    }
                }
            }
        }
        return null;
    }
}