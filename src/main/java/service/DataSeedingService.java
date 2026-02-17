package service;

import connection.ConnectionUtil_HikariCP;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;

public class DataSeedingService {
    public void runDDL() throws Exception {
        // reset schema
        String reset = "DROP SCHEMA public CASCADE;\n" +
                "CREATE SCHEMA public;\n";

        String ddl = Files.readString(Path.of("src/main/resources/strip_ddl.ddl"));
        try (Connection conn = ConnectionUtil_HikariCP.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(reset);
            stmt.execute(ddl);
            System.out.println("Tables created successfully!");
        }
    }

    public void runDML() throws Exception {
        String dml = Files.readString(Path.of("src/main/resources/seed.sql"));
        try (Connection conn = ConnectionUtil_HikariCP.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(dml);
            System.out.println("Data seeded successfully!");
        }
    }
}
