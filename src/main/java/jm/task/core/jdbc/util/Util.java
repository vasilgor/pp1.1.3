package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//"jdbc:postgresql://localhost:5433/first_db", "postgres", "123456"

public class Util {
    public static Connection getConnectionDB() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5433/first_db", "postgres", "123456");

    }
}
