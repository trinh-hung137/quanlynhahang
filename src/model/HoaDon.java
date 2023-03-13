/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author hung
 */
public class HoaDon {

    private int ma_hd, ma_kh, chiet_khau, thanh_tien;
    private Date ngay;
    private Map<MonAn, Integer> monanList;

    public HoaDon() {
    }

    public HoaDon(int ma_hd, int ma_kh, Date ngay, int chiet_khau, int thanh_tien, Map<MonAn, Integer> monanList) {
        this.ma_hd = ma_hd;
        this.ma_kh = ma_kh;
        this.chiet_khau = chiet_khau;
        this.thanh_tien = thanh_tien;
        this.ngay = ngay;
        this.monanList = monanList;
    }

    public int getMa_hd() {
        return ma_hd;
    }

    public void setMa_hd(int ma_hd) {
        this.ma_hd = ma_hd;
    }

    public int getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(int ma_kh) {
        this.ma_kh = ma_kh;
    }

    public int getChiet_khau() {
        return chiet_khau;
    }

    public void setChiet_khau(int chiet_khau) {
        this.chiet_khau = chiet_khau;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Map<MonAn, Integer> getMonanList() {
        return monanList;
    }

    public void setMonanList(Map<MonAn, Integer> monanList) {
        this.monanList = monanList;
    }

}
