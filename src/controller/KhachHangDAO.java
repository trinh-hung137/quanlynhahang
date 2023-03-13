/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author hung
 */
public class KhachHangDAO {

    public KhachHangDAO() {
    }

    public static List<KhachHang> gelAllKhachHang() throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        List<KhachHang> khList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM khach_hang";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String sql1 = "SELECT * FROM kh_sdt WHERE ma_kh = ?";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, rs.getInt("ma_kh"));
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> sdtList = new ArrayList<>();
            while (rs1.next()) {
                String sdt = rs1.getString("sdt");
                sdtList.add(sdt);
            }
            KhachHang kh = new KhachHang(rs.getInt("ma_kh"),
                    rs.getString("ho"), rs.getString("ten_dem"), rs.getString("ten"),
                    rs.getString("so_nha"), rs.getString("duong"), rs.getString("quan_huyen"),
                    rs.getString("tinh_tp"), sdtList);
            khList.add(kh);
        }
        return khList;
    }

    public static KhachHang getKhachHang(int ma_kh)
            throws ClassNotFoundException, IOException, FileNotFoundException,
            SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM khach_hang WHERE MA_KH = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ma_kh);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String sql1 = "SELECT * FROM kh_sdt WHERE ma_kh = ?";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, rs.getInt("ma_kh"));
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> sdtList = new ArrayList<>();
            while (rs1.next()) {
                String sdt = rs1.getString("sdt");
                sdtList.add(sdt);
            }
            KhachHang kh = new KhachHang(rs.getInt("ma_kh"),
                    rs.getString("ho"), rs.getString("ten_dem"), rs.getString("ten"),
                    rs.getString("so_nha"), rs.getString("duong"), rs.getString("quan_huyen"),
                    rs.getString("tinh_tp"), sdtList);
            return kh;
        }
        return null;

    }

    public static void addKhachHang(KhachHang kh) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO khach_hang "
                + "(ho, ten_dem, ten, so_nha, duong, quan_huyen, tinh_tp) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, kh.getHo());
        ps.setString(2, kh.getTen_dem());
        ps.setString(3, kh.getTen());
        ps.setString(4, kh.getSo_nha());
        ps.setString(5, kh.getDuong());
        ps.setString(6, kh.getQuan_huyen());
        ps.setString(7, kh.getTinh_tp());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int ma_kh = 0;
        if (rs.next()) {
            ma_kh = rs.getInt(1);
        } else {
            System.out.println("Cannot get generated key");
            return;
        }

        for (String sdt : kh.getSdtList()) {
            sql = "INSERT INTO kh_sdt (ma_kh, sdt) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ma_kh);
            ps.setString(2, sdt);
            ps.executeUpdate();
        }
    }

    public static void updateKhachHang(KhachHang kh) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "UPDATE khach_hang SET ho = ?, ten_dem = ?, ten = ?, "
                + "so_nha = ?, duong = ?, quan_huyen = ?, tinh_tp = ? "
                + "WHERE MA_KH = ?";
        int ma_kh = kh.getMa_kh();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kh.getHo());
        ps.setString(2, kh.getTen_dem());
        ps.setString(3, kh.getTen());
        ps.setString(4, kh.getSo_nha());
        ps.setString(5, kh.getDuong());
        ps.setString(6, kh.getQuan_huyen());
        ps.setString(7, kh.getTinh_tp());
        ps.setInt(8, ma_kh);
        ps.executeUpdate();

        sql = "DELETE FROM kh_sdt WHERE ma_kh = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, ma_kh);
        ps.executeUpdate();

        for (String sdt : kh.getSdtList()) {
            sql = "INSERT INTO kh_sdt (ma_kh, sdt) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ma_kh);
            ps.setString(2, sdt);
            ps.executeUpdate();
        }

    }

    public static void deleteKhachHang(int ma_kh) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM khach_hang WHERE MA_KH = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ma_kh);
        ps.executeUpdate();
    }

    public static int getSoLan(int ma_kh) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        if (ma_kh == 1) {
            return 0;
        }
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT COUNT(*) FROM hoa_don WHERE ma_kh = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ma_kh);
        ResultSet rs = ps.executeQuery();
        int soLan = 0;
        if (rs.next()) {
            soLan = rs.getInt(1);
        }
        return soLan;
    }
}
