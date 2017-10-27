/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasetapi.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import java.util.Optional;

/**
 *
 * @author erick.valencia.zuta
 */
public class ConnectionHandler {
    
    // Hard coding the database connection!
    Optional<String> host = Optional.ofNullable(System.getenv("HOSTNAME"));
    Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    
    private final String dbms = "mysql";
    private final String serverName = host.orElse("locahost");
    private final String portNumber = port.orElse("3306");
    private final String dbName = "autoclaim";
    private final String userName = "root";
    private final String password = host.orElse("localhost").equals("localhost") ? "root" : "";
    
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Properties connectionProps = new Properties();
            connectionProps.put("user", this.userName);
            connectionProps.put("password", this.password);

            if (this.dbms.equals("mysql")) {
                String url =  "jdbc:" + this.dbms + "://"
                        + this.serverName
                        + ":" + this.portNumber + "/";
                        
                System.out.println("Connecting to... " + url);
                conn = DriverManager.getConnection(url, connectionProps);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
}
