package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class createDatabase {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/";
        String dbUsername = "root";
        String dbPassword = "13579Aa.";

        try(Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmt = connection.createStatement(); ) {

            String sql = "CREATE DATABASE kurs";
            stmt.executeUpdate(sql);
            System.out.println("Database oluşturma tamam...");
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}