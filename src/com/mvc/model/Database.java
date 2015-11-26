/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Zhjjosh
 */
public class Database {

    private static String user = "wumpusAdmin";
    private static String password = "admin";

    public Database() {

    }

    public String[] getNodes() {
        String[] nodes = new String[20];
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
            String dbURL2 = "jdbc:derby://localhost:1527/HuntWumpus;create=true";
            Connection conn = DriverManager.getConnection(dbURL2, user, password);
            if (conn != null) {
                System.out.println("Connected to database #2");
            }
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from nodes ");
            int i = 0;
            while (rset.next()) {
                //System.out.println(rset.getString(1));
                nodes[i] = rset.getString(1);
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nodes;

    }
    
    public String[][] getEdges() {
        String[][] edges = new String[60][3];
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
            String dbURL2 = "jdbc:derby://localhost:1527/HuntWumpus;create=true";
            Connection conn = DriverManager.getConnection(dbURL2, user, password);
            if (conn != null) {
                System.out.println("Connected to database #2");
            }
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from edges ");
            int i = 0;
            while (rset.next()) {
                //System.out.println(rset.getString(1));
                //System.out.println(rset.getString(2));
                //System.out.println(rset.getString(3));
                edges[i][0] = rset.getString(1);
                edges[i][1] = rset.getString(2);
                edges[i][2] = rset.getString(3);
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return edges;

    }
}
