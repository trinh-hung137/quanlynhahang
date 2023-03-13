/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hung
 */
public class MonAn implements Comparable<MonAn>{

    private int ma_ma, don_gia;
    private String ten_mon, don_vi;

    public MonAn() {
    }

    public MonAn(int ma_ma, String ten_mon, int don_gia, String don_vi) {
        this.ma_ma = ma_ma;
        this.ten_mon = ten_mon;
        this.don_gia = don_gia;
        this.don_vi = don_vi;
    }

    public int getMa_ma() {
        return ma_ma;
    }

    public void setMa_ma(int ma_ma) {
        this.ma_ma = ma_ma;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public String getDon_vi() {
        return don_vi;
    }

    public void setDon_vi(String don_vi) {
        this.don_vi = don_vi;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final MonAn ma = (MonAn) obj;
        return this.ma_ma == ma.ma_ma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.ma_ma;
        return hash;
    }

    @Override
    public int compareTo(MonAn o) {
        return ma_ma - o.ma_ma;
    }

}
