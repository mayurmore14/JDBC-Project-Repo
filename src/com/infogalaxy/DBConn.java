package com.infogalaxy;

import java.sql.*;

public class DBConn {
    public static Driver d;
    public static Connection con;
    public static Statement stmt;

    static String URL="jdbc:oracle:thin:@localhost:1521:xe";
    static String Username="system";
    static String password ="infogalaxy";

    public static <SQLException> void openCon() {
        try {
            d = new oracle.jdbc.driver.OracleDriver();
            con = DriverManager.getConnection(URL, Username, password);
            stmt = con.createStatement();
        } catch (java.sql.SQLException se) {
            System.out.println("ERROR in DB Connection");
        }
    }
    public static void nonSelect(String query) {
        try {
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException se) {
            System.out.println("Query Execution Failed");
        }
    }
}
