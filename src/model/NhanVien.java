/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hung
 */
public class NhanVien {

    private int ma_nv, luong;
    private String ho, ten_dem, ten, email;
    private Date ngay_sinh;
    private ArrayList<String> sdtList;

    public NhanVien() {
    }

    public NhanVien(int ma_nv, String ho, String ten_dem, String ten, String email, Date ngay_sinh, int luong, ArrayList<String> sdtList) {
        this.ma_nv = ma_nv;
        this.luong = luong;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.email = email;
        this.ngay_sinh = ngay_sinh;
        this.sdtList = sdtList;
    }

    public int getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(int ma_nv) {
        this.ma_nv = ma_nv;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen_dem() {
        return ten_dem;
    }

    public void setTen_dem(String ten_dem) {
        this.ten_dem = ten_dem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public ArrayList<String> getSdtList() {
        return sdtList;
    }

    public void setSdtList(ArrayList<String> sdtList) {
        this.sdtList = sdtList;
    }

    public String getSdtString() {
        String s = "";
        for (String i : sdtList) {
            s += i + ", ";
        }
        s = s.trim();
        if (s.length() > 1 && s.charAt(s.length() - 1) == ',') {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
    
    public String getHoTen() {
        return ho + " " + ten_dem + (ten_dem.isBlank() ? "" : " ") + ten;
    }

}
