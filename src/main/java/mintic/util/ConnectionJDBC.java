package mintic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static final String DB_LOCATION = "ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + ConnectionJDBC.DB_LOCATION;
        return DriverManager.getConnection(url);
    }
}