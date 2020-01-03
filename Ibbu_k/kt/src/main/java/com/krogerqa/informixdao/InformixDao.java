package com.krogerqa.informixdao;

import java.sql.*;

public class InformixDao {

    public static Connection getSqlConnection(String dbDriver, String URL, String userName, String Password){
        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(URL, userName, Password);


        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ResultSet executeQuery(Connection conn, String query) throws SQLException {

        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int updateOrDeleteRows(Connection conn, String query) throws SQLException {

        int dbcount = 0;
        try {
            Statement stmt = conn.createStatement();
            dbcount = stmt.executeUpdate(query);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return dbcount;
    }

    public static int insertRows(Connection conn, String query) throws  SQLException{
        int insertRecord=0;
        try{
            Statement stmt = conn.createStatement();
            insertRecord=stmt.executeUpdate(query);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return insertRecord;
    }
}
