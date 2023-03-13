/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author hung
 */
public class NhanVienDAO {

    public NhanVienDAO() {
    }

    public static List<NhanVien> getAllNhanVien() throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        List<NhanVien> nvList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM nhan_vien";                 // lấy thông tin tất cả nhân viên
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String sql1 = "SELECT * FROM nv_sdt WHERE ma_nv = ?";   // lấy tất cả sdt 1 nviên 
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, rs.getInt("ma_nv"));
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> sdtList = new ArrayList<>();
            while (rs1.next()) {
                String sdt = rs1.getString("sdt");
                sdtList.add(sdt);
            }
            NhanVien nv = new NhanVien(rs.getInt("ma_nv"),
                    rs.getString("ho"), rs.getString("ten_dem"), rs.getString("ten"),
                    rs.getString("email"), rs.getDate("ngay_sinh"), rs.getInt("luong"), sdtList);
            nvList.add(nv);
        }
        return nvList;
    }

    public static NhanVien getNhanVien(int ma_nv)
            throws ClassNotFoundException, IOException, FileNotFoundException,
            SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM nhan_vien WHERE ma_nv = ?"; // lấy thông tin 1 nhân viên
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ma_nv);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String sql1 = "SELECT * FROM nv_sdt WHERE ma_nv = ?";   // lấy tất cả sdt nviên đó 
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, rs.getInt("ma_nv"));
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> sdtList = new ArrayList<>();
            while (rs1.next()) {
                String sdt = rs1.getString("sdt");
                sdtList.add(sdt);
            }
            NhanVien nv = new NhanVien(rs.getInt("ma_nv"),
                    rs.getString("ho"), rs.getString("ten_dem"), rs.getString("ten"),
                    rs.getString("email"), rs.getDate("ngay_sinh"), rs.getInt("luong"), sdtList);
            return nv;
        }
        return null;

    }

    public static void addNhanVien(NhanVien nv)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO nhan_vien"
                + "(ho, ten_dem, ten, email, ngay_sinh, luong) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, nv.getHo());
        ps.setString(2, nv.getTen_dem());
        ps.setString(3, nv.getTen());
        ps.setString(4, nv.getEmail());
        ps.setDate(5, new java.sql.Date(nv.getNgay_sinh().getTime()));
        ps.setInt(6, nv.getLuong());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int ma_nv = 0;
        if (rs.next()) {
            ma_nv = rs.getInt(1);
        } else {
            System.out.println("Cannot get generated key");
            return;
        }

        for (String sdt : nv.getSdtList()) {
            sql = "INSERT INTO nv_sdt (ma_nv, sdt) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ma_nv);
            ps.setString(2, sdt);
            ps.executeUpdate();
        }
    }

    public static void updateNhanVien(NhanVien nv)
            throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "UPDATE nhan_vien SET ho = ?, ten_dem = ?, ten = ?, "
                + "ngay_sinh = ?, email = ?, luong = ? "
                + "WHERE ma_nv = ?";

        int ma_nv = nv.getMa_nv();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nv.getHo());
        ps.setString(2, nv.getTen_dem());
        ps.setString(3, nv.getTen());
        ps.setDate(4, new java.sql.Date(nv.getNgay_sinh().getTime()));
        ps.setString(5, nv.getEmail());
        ps.setInt(6, nv.getLuong());
        ps.setInt(7, ma_nv);
        ps.executeUpdate();

        sql = "DELETE FROM nv_sdt WHERE ma_nv = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, ma_nv);
        ps.executeUpdate();

        for (String sdt : nv.getSdtList()) {
            sql = "INSERT INTO nv_sdt (ma_nv, sdt) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ma_nv);
            ps.setString(2, sdt);
            ps.executeUpdate();
        }
    }

    public static void deleteNhanVien(int ma_nv) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM nhan_vien WHERE ma_nv = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ma_nv);
        ps.executeUpdate();
    }
}
