package com.proyecto.backend.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DynamicOracleConnection {

    public Connection getConnection(String username, String password) throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";  // Ajusta la URL según tu configuración
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        
        // Verificar si el usuario tiene el rol c##rol_de_instructor
        if (!hasInstructorRole(connection)) {
            throw new SQLException("Usuario no autorizado. El usuario no tiene el rol 'c##rol_de_instructor'.");
        }

        return connection;
    }

    private boolean hasInstructorRole(Connection connection) throws SQLException {
        String query = "SELECT * FROM user_role_privs WHERE granted_role = 'C##ROL_DE_INSTRUCTOR'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next(); // Si hay algún resultado, el usuario tiene el rol c##rol_de_instructor
        }
    }
}



/* package com.proyecto.backend.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DynamicOracleConnection {

    public Connection getConnection(String username, String password) throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";  // Ajusta la URL según tu configuración
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
} */

