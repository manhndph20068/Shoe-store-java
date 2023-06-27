/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author admin
 */
public class QuanLyNhaSanXuat {

    private String id;
    private String ma;
    private String ten;
    private int trangThai;

    public QuanLyNhaSanXuat() {
    }

    public QuanLyNhaSanXuat(String ten) {
        this.ten = ten;
    }

    public QuanLyNhaSanXuat(String id, String ma, String ten, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] todata() {
        return new Object[]{id, ma, ten, trangThai == 0 ? "hoạt động" : " không hoạt động"};
    }

}
