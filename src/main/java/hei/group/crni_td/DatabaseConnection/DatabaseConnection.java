package hei.group.crni_td.DatabaseConnection;

import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/vote_td";
    private static final String USER = "postgres";
    private static final String PASSWORD = "nomena";
    public java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
