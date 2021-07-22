package org.osm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
//  static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
  static final String DB_URL = "jdbc:mariadb://127.0.0.1:3308/osm";
  static final String USER = "paola";
  static final String PASS = "root";
  
  public static void connect(String query) {
    Connection conn = null;
    Statement stmt = null;
    try {
//      Class.forName(JDBC_DRIVER);
      DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      var result = stmt.executeQuery(query);
      var rsmd = result.getMetaData();
      int columnsNumber = rsmd.getColumnCount();
  
      while (result.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
          if (i > 1) System.out.print(",  ");
          String columnValue = result.getString(i);
//          System.out.print(columnValue + " " + rsmd.getColumnName(i));
        }
//        System.out.println();
      }
    } catch (Exception se) {
      se.printStackTrace();
    } finally {
      try {
        if (stmt != null) {
          conn.close();
        }
      } catch (SQLException ignored) {
      }
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException se) {
        se.printStackTrace();
      }//end finally try
    }//end try
  }//end main
}//end JDBCExample
