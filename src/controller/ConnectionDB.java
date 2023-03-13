/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author Duc Thanh
 */
public class ConnectionDB {

    public static Connection getConnection() throws FileNotFoundException,
            ClassNotFoundException, IOException, SQLException {
        Connection conn;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Admin ad = IOFileObject.readFile("src/controller/AD.DAT");
        String url = "jdbc:mysql://"
                + ad.getSqlHostName() + ":"
                + ad.getSqlPort() + "/"
                + ad.getSqlDatabase() + "?allowPublicKeyRetrieval=true&useSSL=false";
        conn = DriverManager.getConnection(url, ad.getSqlUser(), ad.getSqlPassword());
        return conn;
    }
}
