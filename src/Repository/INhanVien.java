/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.NhanVien;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface INhanVien {

    List<NhanVien> getAll();

    boolean add(NhanVien nv);

    boolean update(NhanVien nv, String id);

    boolean delete(String id);

    List<NhanVien> getbyTrangThainv(int trangThai);

    List<NhanVien> getbyChucVunv(int chucVu);

    List<NhanVien> getbyTennv(String ten);

    List<NhanVien> getbyGioiTinh(int gioiTinh);
    
    NhanVien getMaNV(String manv);
}
