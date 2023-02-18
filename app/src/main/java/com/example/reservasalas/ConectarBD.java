package com.example.reservasalas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {
    public static Connection Conecta () {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:reserva_salas.db");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Conectado ao banco de dados");
        return conn;
    }
}
