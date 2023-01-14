package jdbctest;

import java.sql.*;
public class devex {

    public static void main(String[] args) throws SQLException,SQLException {
        String dbUrl = "jdbc:mysql://92.205.106.232:3306/prod";
        String dbUsername = "devex";
        String dbPassword = "dwEde3.4SdKLs98.ds14";

        Connection connection =DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select a.name,a.email,b.company,b.year,b.location,b.status,b.skills,c.title,c.company,c.location as exp_location \n" +
                "from user as a inner join profile as b on a.id=b.userID \n" +
                "inner join experience as c on b.id=c.profileId LIMIT 20");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3) + "-" + resultSet.getInt(4) + "-" + resultSet.getString(5)+ "-" + resultSet.getString(6)+ "-" + resultSet.getString(7)+ "-" + resultSet.getString(8)+ "-" + resultSet.getString(9)+ "-" + resultSet.getString(10));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}