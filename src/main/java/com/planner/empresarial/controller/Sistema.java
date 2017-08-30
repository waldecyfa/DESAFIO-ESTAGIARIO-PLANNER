package com.planner.empresarial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Sistema{
public Connection con =null;
public String url="";
public Statement stmt = null;
public ResultSet res = null;

public Sistema(){

    url = "jdbc:hsqldb:file:c:/BackUP/Util/HsqlDB/hsqldb/demo/teste2"; 

try {
    Class.forName("org.hsqldb.jdbcDriver" );
    JOptionPane.showMessageDialog(null,"Identificou o driver");
    con = DriverManager.getConnection(url, "sa","");
    JOptionPane.showMessageDialog(null,"Conectou");
    stmt = con.createStatement();
    stmt.executeQuery("select * from customer");
    res = stmt.getResultSet();
    while(res.next()){
        System.out.println(res.getString("firstname"));
    }

} catch (Exception e) {
    System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
    e.printStackTrace();
    return;
}


}
public static void main(String args[]){

 Sistema sistema = new Sistema();
}
}





