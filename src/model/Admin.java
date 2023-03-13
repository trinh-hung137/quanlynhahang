/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Duc Thanh
 */
public class Admin implements Serializable {

    private String username, password, cauHoi1, cauHoi2, traLoi1, traLoi2;
    private String sqlHostName, sqlUser, sqlPassword, sqlPort, sqlDatabase;

    public Admin() {
    }

    public Admin(String username, String password,
            String cauHoi1, String cauHoi2, String traLoi1, String traLoi2) {
        this.username = username;
        this.password = password;
        this.cauHoi1 = cauHoi1;
        this.cauHoi2 = cauHoi2;
        this.traLoi1 = traLoi1;
        this.traLoi2 = traLoi2;
    }

    public Admin(String userName, String passWord, 
            String cauHoi1, String cauHoi2, String traLoi1, String traLoi2, 
            String sqlHostName, String sqlUser, String sqlPassword, String sqlPort, String sqlDatabase) {
        this.username = userName;
        this.password = passWord;
        this.cauHoi1 = cauHoi1;
        this.cauHoi2 = cauHoi2;
        this.traLoi1 = traLoi1;
        this.traLoi2 = traLoi2;
        this.sqlHostName = sqlHostName;
        this.sqlUser = sqlUser;
        this.sqlPassword = sqlPassword;
        this.sqlPort = sqlPort;
        this.sqlDatabase = sqlDatabase;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCauHoi1() {
        return cauHoi1;
    }

    public void setCauHoi1(String cauHoi1) {
        this.cauHoi1 = cauHoi1;
    }

    public String getCauHoi2() {
        return cauHoi2;
    }

    public void setCauHoi2(String cauHoi2) {
        this.cauHoi2 = cauHoi2;
    }

    public String getTraLoi1() {
        return traLoi1;
    }

    public void setTraLoi1(String traLoi1) {
        this.traLoi1 = traLoi1;
    }

    public String getTraLoi2() {
        return traLoi2;
    }

    public void setTraLoi2(String traLoi2) {
        this.traLoi2 = traLoi2;
    }

    public String getSqlHostName() {
        return sqlHostName;
    }

    public void setSqlHostName(String sqlHostName) {
        this.sqlHostName = sqlHostName;
    }

    public String getSqlUser() {
        return sqlUser;
    }

    public void setSqlUser(String sqlUser) {
        this.sqlUser = sqlUser;
    }

    public String getSqlPassword() {
        return sqlPassword;
    }

    public void setSqlPassword(String sqlPassword) {
        this.sqlPassword = sqlPassword;
    }

    public String getSqlPort() {
        return sqlPort;
    }

    public void setSqlPort(String sqlPort) {
        this.sqlPort = sqlPort;
    }

    public String getSqlDatabase() {
        return sqlDatabase;
    }

    public void setSqlDatabase(String sqlDatabase) {
        this.sqlDatabase = sqlDatabase;
    }

}
