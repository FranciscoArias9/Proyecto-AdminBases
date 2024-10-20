package com.proyecto.backend.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.backend.dto.LoginRequest;  // <-- IMPORTAR LoginRequest
import com.proyecto.backend.service.DynamicOracleConnection;  // <-- IMPORTAR SQLException

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {

    private DynamicOracleConnection dynamicOracleConnection = new DynamicOracleConnection();

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            // Intentar conectarse a la base de datos con el usuario y la contraseña proporcionados
            Connection connection = dynamicOracleConnection.getConnection(loginRequest.getUsername(), loginRequest.getPassword());
    
            // Si la conexión es exitosa, guardarla en la sesión
            session.setAttribute("dbConnection", connection);
            
            // Devolver un texto plano con el mensaje de éxito
            return ResponseEntity.ok("Login exitoso");
    
        } catch (SQLException e) {
            // Si la conexión falla, enviar un error en texto plano
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas o error en la conexión");
        }
    }
    


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        Connection connection = (Connection) session.getAttribute("dbConnection");
        if (connection != null) {
            try {
                connection.close();  // Desconectar al usuario
            } catch (SQLException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cerrar la conexión");
            }
        }
        session.invalidate();  // Invalida la sesión
        return ResponseEntity.ok("Logout exitoso");
    }
}
