package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class insertTable {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "13579Aa.";

        try(Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmt = connection.createStatement();
        ) {

            String sql = "INSERT INTO kurs.ogrenci (ad, soyad,ders,notu) VALUES ('Fatih','Karadag','Java',100)";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            System.out.println("Table insert oluşturma tamam...");
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
