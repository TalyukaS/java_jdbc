package com.company;

import java.sql.*;

public class Db {
    private Connection dbconnect = null;
    private Connection getDbConnect() throws ClassNotFoundException, SQLException {
        String HOST = "localhost";
        String PORT = "3306";
        String DBNAME = "javadb";
        String connstr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME +
        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String LOGIN = "root";
        String PASS = "";
        dbconnect = DriverManager.getConnection(connstr, LOGIN, PASS);
        return dbconnect;
    }
    public void isConnected() throws SQLException, ClassNotFoundException {
        dbconnect = getDbConnect();
        System.out.println(dbconnect.isValid(1000));
    }
    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        String sqlTab = "CREATE TABLE IF NOT EXISTS " + tableName
                + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))"
                + " ENGINE=MYISAM;";
        Statement statment = getDbConnect().createStatement();
        statment.executeUpdate(sqlTab);
    }
    public void insertArticles(String title, String text, String data, String avtor) throws SQLException, ClassNotFoundException {
        String sqlInsTab = "INSERT INTO `articles` (title, text, data, avtor) VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnect().prepareStatement(sqlInsTab);
        prSt.setString(1, title);
        prSt.setString(2, text);
        prSt.setString(3, data);
        prSt.setString(4, avtor);
        prSt.executeUpdate();
    }
}
