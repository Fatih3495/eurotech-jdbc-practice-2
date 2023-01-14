package jdbctest;

import java.sql.*;

public class preInsert {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "13579Aa.";

        String sql = "INSERT INTO kurs.ogrenci (ad,soyad,ders,notu) VALUES" + "(?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,"Hasan");
            preparedStatement.setString(2, "CAN");
            preparedStatement.setString(3, "C++");
            preparedStatement.setInt(4, 65);
            preparedStatement.executeUpdate();
            //connection.commit();
            System.out.println("Insert table tamam");
            preparedStatement.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}