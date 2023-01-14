package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class select {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/kurs";
        String dbUsername = "root";
        String dbPassword = "13579Aa.";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //String sql ="SELECT * FROM ogrenci";

        ResultSet resultSet = statement.executeQuery("SELECT * FROM ogrenci");

        resultSet.next();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) +"-"+resultSet.getString(2)+"-"+
                    resultSet.getString(3)+"-"+ resultSet.getString(4)+"-"+
                    resultSet.getInt(5));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}