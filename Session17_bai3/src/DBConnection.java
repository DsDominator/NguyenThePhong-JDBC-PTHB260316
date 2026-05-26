package ra.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/library_db";

    private static final String USER = "postgres";

    private static final String PASSWORD = "123456";

    public static Connection getConnection()
            throws SQLException {

        try {

            Class.forName(
                    "org.postgresql.Driver"
            );

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "Không tìm thấy PostgreSQL Driver!"
            );
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
