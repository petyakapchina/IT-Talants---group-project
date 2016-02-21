package instagram;

import java.sql.*;


public class SQLtest {


    // ����� ����� �� ������� ��� SQL ������� � ����� ������ (������) ��� ����,
    // � ��� ����������� � ���������, �� ����� NULL
    private static Connection connect(String url, String user, String password) {
        Connection result = null;
        try {
            result = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void call() {
        // localhost � IP �� �������, 3306 � �����, instagram � ������
        String url = "jdbc:mysql://127.0.0.1:3306/instagram";
        String user = "root";
        String pass = "";

        Connection link = SQLtest.connect(url, user, pass);

        if (link == null) {
            System.out.println("MySQL isn't on");

        } else {
            System.out.println("Connection with MySQL: successful");
        }

        // � JDBC Statement � ��������, � ResultSet � ��������� �� ���
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            stmt = link.createStatement();
            resultSet = stmt.executeQuery("SELECT name, email, phone FROM employees");

            // ��������� ������������ ������� ��� �� ��� � ����������� �� ������
            while (resultSet.next()) {
                System.out.print("name: " + resultSet.getString("name"));
                System.out.print(", email: " + resultSet.getString("email"));
                System.out.println(", phone " + resultSet.getLong("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (resultSet != null) resultSet.close();
                if (link != null) link.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
