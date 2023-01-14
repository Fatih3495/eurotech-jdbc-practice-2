package jdbctest;

import java.sql.*;
public class callable_statement {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "13579Aa.";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        CallableStatement callable = connection.prepareCall("CALL kurs.Sp_ogrenci_select");
        ResultSet resultSet = callable.executeQuery();


        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) +"-"+resultSet.getString(2)+"-"+
                    resultSet.getString(3)+"-"+ resultSet.getString(4)+"-"+
                    resultSet.getInt(5));
        }

        resultSet.close();
        callable.close();
        connection.close();
    }
}