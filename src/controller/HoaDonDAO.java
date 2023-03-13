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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import model.HoaDon;
import model.MonAn;

/**
 *
 * @author hung
 */
public class HoaDonDAO {

    public HoaDonDAO() {
    }

    public static List<HoaDon> getAllHoaDon()
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        List<HoaDon> hdList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM hoa_don_view";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ma_hd = rs.getInt("ma_hd");
            int ma_kh = rs.getInt("ma_kh");
            Date ngay = rs.getDate("ngay");
            int chiet_khau = rs.getInt("chiet_khau");
            int thanh_tien = rs.getInt("thanh_tien");

            String sql1 = "SELECT * FROM hd_ma JOIN mon_an ON hd_ma.ma_ma = mon_an.ma_ma WHERE ma_hd = ?";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, ma_hd);
            ResultSet rs1 = ps1.executeQuery();
            Map<MonAn, Integer> maList = new TreeMap<>();
            while (rs1.next()) {
                int ma_ma = rs1.getInt("ma_ma");
                String ten_mon = rs1.getString("ten_mon");
                int don_gia = rs1.getInt("hd_ma.don_gia");
                String don_vi = rs1.getString("don_vi");
                int soLuong = rs1.getInt("so_luong");
                maList.put(new MonAn(ma_ma, ten_mon, don_gia, don_vi), soLuong);
                
            }
            hdList.add(new HoaDon(ma_hd, ma_kh, ngay, chiet_khau, thanh_tien, maList));
        }
        return hdList;
    }

    public static HoaDon getHoaDon(int ma_hd)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM hoa_don_view WHERE ma_hd = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ma_hd);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ma_kh = rs.getInt("ma_kh");
            Date ngay = rs.getDate("ngay");
            int chiet_khau = rs.getInt("chiet_khau");
            int thanh_tien = rs.getInt("thanh_tien");

            String sql1 = "SELECT * FROM hd_ma JOIN mon_an ON hd_ma.ma_ma = mon_an.ma_ma WHERE ma_hd = ?";  //gộp 2 bảng hd_ma và ma
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, ma_hd);
            ResultSet rs1 = ps1.executeQuery();
            Map<MonAn, Integer> maList = new TreeMap<>();
            while (rs1.next()) {
                int ma_ma = rs1.getInt("ma_ma");
                String ten_mon = rs1.getString("ten_mon");
                int don_gia = rs1.getInt("hd_ma.don_gia");
                String don_vi = rs1.getString("don_vi");
                int soLuong = rs1.getInt("so_luong");
                maList.put(new MonAn(ma_ma, ten_mon, don_gia, don_vi), soLuong);
                
            }
            return new HoaDon(ma_hd, ma_kh, ngay, chiet_khau, thanh_tien, maList);
        }
        return null;
    }

    public static int addHoaDon(HoaDon hd)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO hoa_don(ma_kh, ngay) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, hd.getMa_kh());
        ps.setDate(2, new java.sql.Date(hd.getNgay().getTime()));
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int ma_hd = 0;
        if (rs.next()) {
            ma_hd = rs.getInt(1);
        } else {
            System.out.println("Cannot get generated key");
            return 0;
        }

        for (MonAn ma : hd.getMonanList().keySet()) {
            sql = "INSERT INTO hd_ma (ma_hd, ma_ma, so_luong, don_gia) VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ma_hd);
            ps.setInt(2, ma.getMa_ma());
            ps.setInt(3, hd.getMonanList().get(ma));
            ps.setInt(4, ma.getDon_gia());
            ps.executeUpdate();
        }

        return ma_hd;
    }

    public static void deleteHoaDon(int ma_hd)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM hoa_don where ma_hd = ?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, ma_hd);
        ps.executeUpdate();
    }

    public static List<HoaDon> getAllHoaDonByDate(int year, int month, int day)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        List<HoaDon> hdList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();

        String sql = "SELECT * FROM hoa_don_view WHERE YEAR(ngay) = " + year;
        if (month != 0) {
            sql += " AND MONTH(ngay) = " + month;
        }
        if (day != 0) {
            sql += " AND DAY(ngay) = " + day;
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ma_hd = rs.getInt("ma_hd");
            int ma_kh = rs.getInt("ma_kh");
            Date ngay = rs.getDate("ngay");
            int chiet_khau = rs.getInt("chiet_khau");
            int thanh_tien = rs.getInt("thanh_tien");

            String sql1 = "SELECT * FROM hd_ma JOIN mon_an ON hd_ma.ma_ma = mon_an.ma_ma WHERE ma_hd = ?";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, ma_hd);
            ResultSet rs1 = ps1.executeQuery();
            Map<MonAn, Integer> maList = new TreeMap<>();
            while (rs1.next()) {
                int ma_ma = rs1.getInt("ma_ma");
                String ten_mon = rs1.getString("ten_mon");
                int don_gia = rs1.getInt("hd_ma.don_gia");
                String don_vi = rs1.getString("don_vi");
                int soLuong = rs1.getInt("so_luong");
                maList.put(new MonAn(ma_ma, ten_mon, don_gia, don_vi), soLuong);
                
            }
            hdList.add(new HoaDon(ma_hd, ma_kh, ngay, chiet_khau, thanh_tien, maList));
        }
        return hdList;
    }

    public static int tongSoHdByDate(int year, int month, int day)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT COUNT(*) FROM hoa_don_view WHERE YEAR(ngay) = " + year;
        if (month != 0) {
            sql += " AND MONTH(ngay) = " + month;
        }
        if (day != 0) {
            sql += " AND DAY(ngay) = " + day;
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public static int tongDoanhThuByDate(int year, int month, int day)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT SUM(thanh_tien) FROM hoa_don_view WHERE YEAR(ngay) = " + year;
        if (month != 0) {
            sql += " AND MONTH(ngay) = " + month;
        }
        if (day != 0) {
            sql += " AND DAY(ngay) = " + day;
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

}
