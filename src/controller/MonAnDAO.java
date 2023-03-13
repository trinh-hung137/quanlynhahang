/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MonAn;

/**
 *
 * @author hung
 */
public class MonAnDAO {

    public static List<MonAn> getAllMonAn() throws ClassNotFoundException,
            IOException, FileNotFoundException, SQLException {
        List<MonAn> maList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM mon_an ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);          
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            MonAn ma = new MonAn(rs.getInt("ma_ma"), rs.getString("ten_mon"),
                    rs.getInt("don_gia"), rs.getString("don_vi"));
            maList.add(ma);
        }
        return maList;
    }

    public static MonAn getMonAn(int ma_ma) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM mon_an WHERE ma_ma = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, ma_ma);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            MonAn ma = new MonAn(rs.getInt("ma_ma"), rs.getString("ten_mon"),
                    rs.getInt("don_gia"), rs.getString("don_vi"));
            return ma;
        }
        return null;
    }

    public static void addMonAn(MonAn ma) throws ClassNotFoundException,
            IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO mon_an (ten_mon, don_gia, don_vi) "
                + "VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, ma.getTen_mon());
        ps.setInt(2, ma.getDon_gia());
        ps.setString(3, ma.getDon_vi());

        ps.executeUpdate();
    }

    public static void updateMonAn(MonAn ma) throws ClassNotFoundException,
            IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "UPDATE mon_an SET ten_mon = ?, don_gia = ?, don_vi = ? "
                + "WHERE ma_ma = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, ma.getTen_mon());
        ps.setInt(2, ma.getDon_gia());
        ps.setString(3, ma.getDon_vi());
        ps.setInt(4, ma.getMa_ma());

        ps.executeUpdate();
    }

    public static void deleteMonAn(int ma_ma) throws ClassNotFoundException,
            IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM mon_an WHERE ma_ma = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, ma_ma);

        preparedStatement.executeUpdate();
    }
}
