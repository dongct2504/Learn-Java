package test.testJDBC;

import java.sql.*;

public class TestJDBC {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/test";
    String uname = "root";
    String passwd = "01646245557";

    String query = "SELECT * FROM student";

    try {
      Connection con = DriverManager.getConnection(url, uname, passwd);

      Statement statement = con.createStatement();

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        String name = resultSet.getString("name");
        System.out.println(name);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}









