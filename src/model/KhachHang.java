/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hung
 */
public class KhachHang {

    private int ma_kh;
    private String ho, ten_dem, ten, so_nha, duong, quan_huyen, tinh_tp;
    private ArrayList<String> sdtList;

    public KhachHang() {
        sdtList = new ArrayList<>();
    }

    public KhachHang(int ma_kh, String ho, String ten_dem, String ten, String so_nha, String duong, String quan_huyen, String tinh_tp, ArrayList<String> sdtList) {
        this.ma_kh = ma_kh;
        this.so_nha = so_nha;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.duong = duong;
        this.quan_huyen = quan_huyen;
        this.tinh_tp = tinh_tp;
        this.sdtList = sdtList;
    }

    public int getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(int ma_kh) {
        this.ma_kh = ma_kh;
    }

    public String getSo_nha() {
        return so_nha;
    }

    public void setSo_nha(String so_nha) {
        this.so_nha = so_nha;
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

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getQuan_huyen() {
        return quan_huyen;
    }

    public void setQuan_huyen(String quan_huyen) {
        this.quan_huyen = quan_huyen;
    }

    public String getTinh_tp() {
        return tinh_tp;
    }

    public void setTinh_tp(String tinh_tp) {
        this.tinh_tp = tinh_tp;
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

    public String getDiaChi() {
        String s = "";
        if (!so_nha.isEmpty()) {
            s += so_nha + " ";
        }
        if (!duong.isEmpty()) {
            s += duong + ", ";
        }
        if (!quan_huyen.isEmpty()) {
            s += quan_huyen + ", ";
        }
        if (!tinh_tp.isEmpty()) {
            s += tinh_tp;
        }
        return s;
    }
}
